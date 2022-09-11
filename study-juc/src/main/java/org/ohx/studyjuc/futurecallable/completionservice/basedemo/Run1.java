package org.ohx.studyjuc.futurecallable.completionservice.basedemo;

import java.util.Random;
import java.util.concurrent.*;

public class Run1 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        try {
            CompletionService<String> executorCompletionService = new ExecutorCompletionService<>(executor);
            for (int i = 0; i < 5; i++) {
                executorCompletionService.submit(() -> {
                    Thread.sleep(new Random().nextInt(10));
                    return Thread.currentThread().getName() + "完成";
                });
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("等待打印第" + (i + 1) + "返回值");
                System.out.println(executorCompletionService.take().get());
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
