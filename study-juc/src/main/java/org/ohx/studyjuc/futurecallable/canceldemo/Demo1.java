package org.ohx.studyjuc.futurecallable.canceldemo;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/7/13
 */
public class Demo1 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 5L, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>());
        try {
            Future<String> future = threadPoolExecutor.submit(() -> {
                TimeUnit.SECONDS.sleep(3);
                return "100";
            });
            System.out.println(future.cancel(true) + " " + future.isCancelled());
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
