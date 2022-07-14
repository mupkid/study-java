package org.ohx.studyjuc.futurecallable.basedemo;

import java.util.concurrent.*;

/**
 * @author mudkip
 * @date 2022/7/13
 */
public class Demo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 5L, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>());
        try {
            Future<String> future = threadPoolExecutor.submit(() -> {
                TimeUnit.SECONDS.sleep(3);
                return "100";
            });
            System.out.println("before get " + System.currentTimeMillis());
            System.out.println("get " + future.get());
            System.out.println("after get " + System.currentTimeMillis());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
