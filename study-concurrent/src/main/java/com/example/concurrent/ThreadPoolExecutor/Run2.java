package com.example.concurrent.ThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run2 {

    /**
     * 队列使用LinkedBlockingDeque类
     * 并且线程数量<=corePoolSize
     * 所以keepAliveTime>5时也不清楚空闲线程
     */
    public static void main(String[] args) throws InterruptedException {
//        test1();
        test2();
    }

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
