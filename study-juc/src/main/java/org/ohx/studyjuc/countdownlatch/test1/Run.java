package org.ohx.studyjuc.countdownlatch.test1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/7/12
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                myResource.await();
            }, i + 1 + "").start();
        }

        TimeUnit.SECONDS.sleep(3);
        myResource.countdown();
    }
}

class MyResource {
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public void await() {
        try {
            System.out.println(Thread.currentThread().getName() + " await at " + System.currentTimeMillis());
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + " start at " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void countdown() {
        System.out.println("open");
        countDownLatch.countDown();
    }
}