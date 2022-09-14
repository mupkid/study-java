package org.ohx.studyjuc.futurecallable.completablefuture;

import java.util.concurrent.*;

/**
 * @author mudkip
 * @date 2022/9/14
 */
public class Demo9 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>());

        try {
            CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task 1 is " + Thread.currentThread().getName());
                return "111";
            }).thenRun(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task 2 is " + Thread.currentThread().getName());
            }).thenRunAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task 3 is " + Thread.currentThread().getName());
            }, threadPool).thenRun(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task 4 is " + Thread.currentThread().getName());
            });

            System.out.println(completableFuture.get(10L, TimeUnit.SECONDS));
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
