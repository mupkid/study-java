package org.ohx.studyjuc.threadpool.threadpoolexecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run3 {

    public static void main(String[] args) throws InterruptedException {
//        test1();
        test2();
    }

    /**
     * 队列使用LinkedBlockingDeque
     * maximumPoolSize8>=任务数量8>corePoolSize7
     * 同一个时间最多只有corePoolSize个线程运行
     * 其余的任务放入队列等待执行
     * 当线程空闲时间>keepAliveTime时会清除
     * 因此使用LinkedBlockingDeque时maximumPoolSize参数将忽略
     */
    public static void test1() throws InterruptedException{
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println(Thread.currentThread().getName() + " begin "+ System.currentTimeMillis());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7,8,5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        // 8个
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);

        Thread.sleep(300);

        System.out.println("Before 10s CorePoolSize:" + executor.getCorePoolSize());
        System.out.println("Before 10s PoolSize:" + executor.getPoolSize());
        System.out.println("Before 10s QueueSize:" + executor.getQueue().size());
        Thread.sleep(10000);
        System.out.println("After 10s CorePoolSize:" + executor.getCorePoolSize());
        System.out.println("After 10s PoolSize:" + executor.getCorePoolSize());
        System.out.println("After 10s QueueSize:" + executor.getQueue().size());

        executor.shutdown();
    }

    /**
     * 队列使用SynchronousQueue
     * maximumPoolSize8>=任务数量8>corePoolSize7
     * 线程池将创建8个线程完成所有任务
     * 任务不放入队列中
     * 当线程空闲时间>keepAliveTime时会清除
     */
    public static void test2() throws InterruptedException{
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println(Thread.currentThread().getName() + " begin "+ System.currentTimeMillis());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7,8,5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        // 8个
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);

        Thread.sleep(300);

        System.out.println("Before 10s CorePoolSize:" + executor.getCorePoolSize());
        System.out.println("Before 10s PoolSize:" + executor.getPoolSize());
        System.out.println("Before 10s QueueSize:" + executor.getQueue().size());
        Thread.sleep(10000);
        System.out.println("After 10s CorePoolSize:" + executor.getCorePoolSize());
        System.out.println("After 10s PoolSize:" + executor.getCorePoolSize());
        System.out.println("After 10s QueueSize:" + executor.getQueue().size());

        executor.shutdown();
    }
}
