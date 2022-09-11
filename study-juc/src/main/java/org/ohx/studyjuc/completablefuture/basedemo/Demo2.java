package org.ohx.studyjuc.completablefuture.basedemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * @author mudkip
 * @date 2022/7/14
 */
public class Demo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "hello SupplyAsync";
        }, Executors.newFixedThreadPool(5));
        System.out.println(completableFuture.get());
    }
}
