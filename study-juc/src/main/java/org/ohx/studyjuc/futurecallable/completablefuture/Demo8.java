package org.ohx.studyjuc.futurecallable.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @author mudkip
 * @date 2022/9/14
 */
public class Demo8 {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            return 1;
        }).thenApply(f -> {
            return f + 2;
        }).thenRun(() -> {
            System.out.println("什么都没干");
        });
    }
}
