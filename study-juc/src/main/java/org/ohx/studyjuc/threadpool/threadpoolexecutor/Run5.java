package org.ohx.studyjuc.threadpool.threadpoolexecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run5 {

    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
//        test4();
    }

    /**
     * 没有创建线程
     */
    public static void test1() {
        MyRunnable myRunnable = new MyRunnable();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 10, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        System.out.println("main end");
    }

    /**
     * 创建线程，没有执行shutdown()
     */
    public static void test2() {
        MyRunnable myRunnable = new MyRunnable();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 10, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        executor.execute(myRunnable);
        System.out.println("main end");
    }

    /**
     * 执行了shutdown()
     */
    public static void test3() {
        MyRunnable myRunnable = new MyRunnable();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 10, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        executor.execute(myRunnable);
        executor.shutdown();
        System.out.println("main end");
    }

    /**
     * 执行了shutdown()后再添加任务
     * 抛出异常RejectedExecutionException
     * 原有任务继续执行
     */
    public static void test4() {
        try {
            MyRunnable myRunnable = new MyRunnable();
            ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 99999, 9999L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
            executor.execute(myRunnable);
            executor.execute(myRunnable);
            executor.execute(myRunnable);
            executor.execute(myRunnable);
            Thread.sleep(1000);
            executor.shutdown();
            executor.execute(myRunnable);
            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
                Thread.sleep(4000);
                System.out.println(Thread.currentThread().getName() + " end " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
