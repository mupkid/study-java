package com.example.concurrent.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run3 {

    /**
     * 从打印结果可以看出线程池中的线程被复用了
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyRunnable((i + 1) + ""));
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
            System.out.println(Thread.currentThread().getName() + " name=" + name + " bgein " + System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() + " name=" + name + " end " + System.currentTimeMillis());
        }
    }
}

