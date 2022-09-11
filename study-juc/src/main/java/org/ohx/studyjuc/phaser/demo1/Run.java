package org.ohx.studyjuc.phaser.demo1;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/7/12
 */
public class Run {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\tbarrier1 begin");
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName() + "\tbarrier1 end");

                System.out.println(Thread.currentThread().getName() + "\tbarrier2 begin");
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName() + "\tbarrier2 end");
            }, i + 1 + "").start();
        }

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\tbarrier1 begin");
                System.out.println("deregister before\t" + phaser.getRegisteredParties());
                phaser.arriveAndDeregister();
                System.out.println("deregister after\t" + phaser.getRegisteredParties());
                System.out.println(Thread.currentThread().getName() + "\tbarrier1 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "3").start();
    }
}
