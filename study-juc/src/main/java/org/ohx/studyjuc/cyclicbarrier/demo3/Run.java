package org.ohx.studyjuc.cyclicbarrier.demo3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author mudkip
 * @date 2022/7/12
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> System.out.println("都到了"));

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    if ("1".equals(Thread.currentThread().getName())) {
                        System.out.println(Thread.currentThread().getName() + "到了，等待");
                        cyclicBarrier.await(5, TimeUnit.SECONDS);
                    }
                    if ("2".equals(Thread.currentThread().getName())) {
                        TimeUnit.SECONDS.sleep(6);
                        System.out.println(Thread.currentThread().getName() + "到了，等待");
                        cyclicBarrier.await();
                    }
                    System.out.println("都到了！");
                    System.out.println(Thread.currentThread().getName() + "完成");
                } catch (BrokenBarrierException e) {
                    System.out.println(Thread.currentThread().getName() + "进入BrokenBarrierException");
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "进入InterruptedException");
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    System.out.println(Thread.currentThread().getName() + "进入TimeoutException");
                    e.printStackTrace();
                }
            }, i + 1 + "").start();
        }

        TimeUnit.SECONDS.sleep(10);
        System.out.println(cyclicBarrier.isBroken());
    }
}
