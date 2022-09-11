package org.ohx.studyjuc.cyclicbarrier.demo2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author mudkip
 * @date 2022/7/12
 */
public class Run {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("都到了"));

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "到了，等待");
                    if (Thread.currentThread().getName().equals("2")) {
                        Thread.currentThread().interrupt();
                    }
                    cyclicBarrier.await();
                    System.out.println("都到了！");
                    System.out.println(Thread.currentThread().getName() + "完成");
                } catch (BrokenBarrierException | InterruptedException e) {
                    e.printStackTrace();
                }
            }, i + 1 + "").start();
        }
    }
}
