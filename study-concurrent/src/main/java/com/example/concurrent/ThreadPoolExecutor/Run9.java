package com.example.concurrent.ThreadPoolExecutor;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run9 {

    public static void main(String[] args) {
        SynchronousQueueTest1();
    }

    public static void SynchronousQueueTest1() {
        // 使用SynchronousQueue
        SynchronousQueue<Runnable> queue = new SynchronousQueue<>();
        System.out.println(queue.size());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, queue);
        // 4个任务
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        // 执行3个任务，剩余1个没有放入队列被拒绝
        System.out.println(executor.getPoolSize() + " " + queue.size());
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
