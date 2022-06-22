package org.ohx.studyjuc.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newCachedThreadPool()创建无界线程池
 * 存放线程个数是理论上的Integer.MAX_VALUE最大值
 */
public class Run1 {

    /**
     * 从打印的时间可以看出，A和B几乎是在相同的时间开始的，也就是创建了两个线程
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                System.out.println("Runnable1 begin " + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("A");
                System.out.println("Runnable1  end " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                System.out.println("Runnable2 begin " + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("B");
                System.out.println("Runnable2  end " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
