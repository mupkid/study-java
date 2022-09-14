package org.ohx.studyjuc.futurecallable.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/9/12
 */
public class Demo5 {

    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });

//        System.out.println(completableFuture.get());
//        System.out.println(completableFuture.get(1L, TimeUnit.SECONDS));
//        System.out.println(completableFuture.get(2L, TimeUnit.SECONDS));
//        System.out.println(completableFuture.join());

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(completableFuture.complete("completeValue") + " " + completableFuture.join());
    }
}
