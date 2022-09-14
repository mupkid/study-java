package org.ohx.studyjuc.futurecallable.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/9/12
 */
public class Demo6 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>());

        try {
            CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Step one");
                return 1;
            }, threadPoolExecutor).thenApply(f -> {
                System.out.println("Step two");
                return f + 2;
            }).thenApply(f -> {
                System.out.println("Step three");
                return f + 3;
            }).whenComplete((v, e) -> {
                if (e == null) {
                    System.out.println("result: " + v);
                }
            }).exceptionally(e -> {
                e.printStackTrace();
                return 0;
            });

            System.out.println(Thread.currentThread().getName() + "---- 先去忙别的了。");
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
