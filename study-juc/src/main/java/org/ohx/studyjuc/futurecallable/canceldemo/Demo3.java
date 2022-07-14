package org.ohx.studyjuc.futurecallable.canceldemo;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/7/13
 */
public class Demo3 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 5L, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>());
        try {
            Future<String> future = threadPoolExecutor.submit(() -> {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException();
                    }
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("正在运行中");
                }
            });
            TimeUnit.SECONDS.sleep(4);
            System.out.println(future.cancel(true) + " " + future.isCancelled());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
