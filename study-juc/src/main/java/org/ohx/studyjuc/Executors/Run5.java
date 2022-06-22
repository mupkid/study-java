package org.ohx.studyjuc.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newFixedThreadPool方法创建有界线程池
 */
public class Run5 {

    /**
     * 可以从运行结果看出最多只有3个线程在运行
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(new MyRunnable(i+1+""));
        }
        for (int i = 0; i < 3; i++) {
            executorService.execute(new MyRunnable(i+1+""));
        }
        executorService.shutdown();
    }

    static class MyRunnable implements Runnable {

        private String name;

        public MyRunnable(String name) {
            super();
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " name=" + name + " bgein " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " name=" + name + " end " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
