package com.example.concurrent.ThreadPoolExecutor;

import java.util.concurrent.*;

public class Run1 {

    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), myThreadFactory);
        System.out.println(threadPoolExecutor.getCorePoolSize());
        System.out.println(threadPoolExecutor.getMaximumPoolSize());
        System.out.println("****************");
        threadPoolExecutor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), myThreadFactory);
        System.out.println(threadPoolExecutor.getCorePoolSize());
        System.out.println(threadPoolExecutor.getMaximumPoolSize());
    }
}
