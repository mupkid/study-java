package org.ohx.studyjuc.completionservice.exceptiondemo;

import java.util.concurrent.*;

/**
 * @author mudkip
 * @date 2022/7/14
 */
public class Demo1 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        try {
            CompletionService<String> executorCompletionService = new ExecutorCompletionService<>(executor);
            executorCompletionService.submit(() -> {
                TimeUnit.SECONDS.sleep(3);
                return "returnA";
            });
            executorCompletionService.submit(() -> {
                Integer.parseInt("a");
                return "returnA";
            });
            for (int i = 0; i < 2; i++) {
                System.out.println(executorCompletionService.take().get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("catch ExecutionException");
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
