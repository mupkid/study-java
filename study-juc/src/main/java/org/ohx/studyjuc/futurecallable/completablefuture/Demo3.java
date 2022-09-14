package org.ohx.studyjuc.futurecallable.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/7/14
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result;
        }).whenComplete((v, e) -> {
            System.out.println("获得结果：" + v);
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println("出现异常：" + e.getCause() + " " + e.getMessage());
            return null;
        });

        System.out.println(Thread.currentThread().getName() + "线程先去忙别的任务");
        TimeUnit.SECONDS.sleep(5);
    }
}
