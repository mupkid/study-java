package org.ohx.studyjuc.ThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run7 {

    public static void main(String[] args) {
//        LinkedBlockingDequeTest1();
//        LinkedBlockingDequeTest2();
        LinkedBlockingDequeTest3();
    }

    public static void LinkedBlockingDequeTest1(){
        // 队列大小为2
        LinkedBlockingDeque<Runnable> deque = new LinkedBlockingDeque<>(2);
        System.out.println(deque.size());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, deque);
        // 5个任务
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        // 执行3个任务，队列放入2个
        System.out.println(executor.getPoolSize()+" "+deque.size());
        executor.shutdown();
    }

    public static void LinkedBlockingDequeTest2(){
        // 队列大小为2
        LinkedBlockingDeque<Runnable> deque = new LinkedBlockingDeque<>(2);
        System.out.println(deque.size());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, deque);
        // 6个任务
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        // 执行3个任务，队列放入2个，剩下1个任务被拒绝
        System.out.println(executor.getPoolSize()+" "+deque.size());
        executor.shutdown();
    }

    public static void LinkedBlockingDequeTest3(){
        // 队列大小为2
        LinkedBlockingDeque<Runnable> deque = new LinkedBlockingDeque<>();
        System.out.println(deque.size());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, deque);
        // 6个任务
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        // 执行3个任务，队列放入3个
        System.out.println(executor.getPoolSize()+" "+deque.size());
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
