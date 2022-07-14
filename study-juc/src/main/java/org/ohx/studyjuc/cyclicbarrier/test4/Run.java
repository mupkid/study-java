package org.ohx.studyjuc.cyclicbarrier.test4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/7/12
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("都到了"));

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    if ("3".equals(Thread.currentThread().getName())) {
                        TimeUnit.SECONDS.sleep(5);
                    }
                    System.out.println(Thread.currentThread().getName() + "准备");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "结束");
                } catch (BrokenBarrierException | InterruptedException e) {
                    e.printStackTrace();
                }
            }, i + 1 + "").start();
        }

        TimeUnit.SECONDS.sleep(1);
        cyclicBarrier.reset();
    }
}
