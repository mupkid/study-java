package org.ohx.studyjuc.threadpool.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run4 {

    /**
     * 可以通过线程工厂定制线程
     */
    public static void main(String[] args) {
        MyThreadFactory threadFactory = new MyThreadFactory();
        ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
        });
        executorService.shutdown();
    }
}
