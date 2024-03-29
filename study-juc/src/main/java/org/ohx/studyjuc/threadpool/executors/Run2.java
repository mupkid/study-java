package org.ohx.studyjuc.threadpool.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run2 {

    /**
     * 从打印结果可以看出Executors创建的是线程池
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

