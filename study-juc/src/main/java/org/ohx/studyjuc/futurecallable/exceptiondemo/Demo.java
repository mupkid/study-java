package org.ohx.studyjuc.futurecallable.exceptiondemo;

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
                Integer.parseInt("a");
                return "100";
            });
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("出错了");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
