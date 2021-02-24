package com.example.concurrent.ThreadPoolExecutor;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run6 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 从打印结果可以看出执行两个任务的过程中线程被中断了
     * 剩下两个任务被取消，没有运行
     */
    public static void test1() {
        try {
            MyRunnable myRunnable = new MyRunnable();
            ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 99999, 9999L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
            executor.execute(myRunnable);
            executor.execute(myRunnable);
            executor.execute(myRunnable);
            executor.execute(myRunnable);
            Thread.sleep(1000);
            List<Runnable> runnables = executor.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < Integer.MAX_VALUE / 50; i++) {
                    String string = new String();
                    Math.random();
                    Math.random();
                    Math.random();
                    Math.random();
                    Math.random();
                    Math.random();

                    if (Thread.currentThread().isInterrupted() == true) {
                        System.out.println(Thread.currentThread().getName() + " 任务没有完成，就中断了！");
                        throw new InterruptedException();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " 任务成功完成！");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 进入catch中断了任务");
                e.printStackTrace();
            }
        }
    }
}
