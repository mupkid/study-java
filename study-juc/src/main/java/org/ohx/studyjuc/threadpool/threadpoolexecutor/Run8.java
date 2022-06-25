package org.ohx.studyjuc.threadpool.threadpoolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run8 {

    public static void main(String[] args) {
//        ArrayBlockingQueueTest1();
        ArrayBlockingQueueTest2();
    }

    public static void ArrayBlockingQueueTest1() {
        // 使用ArrayBlockingQueue，长度2
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        System.out.println(arrayBlockingQueue.size());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, arrayBlockingQueue);
        // 5个任务
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        // 执行3个任务，放入队列2个
        System.out.println(executor.getPoolSize() + " " + arrayBlockingQueue.size());
        executor.shutdown();
    }

    public static void ArrayBlockingQueueTest2() {
        // 使用ArrayBlockingQueue，长度2
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        System.out.println(arrayBlockingQueue.size());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, arrayBlockingQueue);
        // 6个任务
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        // 执行3个任务，放入队列2个，剩下1个被拒绝抛出异常
        System.out.println(executor.getPoolSize() + " " + arrayBlockingQueue.size());
        executor.shutdown();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " end " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
