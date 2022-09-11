package org.ohx.studyjuc.phaser.demo2;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/7/13
 */
public class Run {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("调用onAdvance");
                // 返回true不等待了，Phaser呈无效/销毁的状态
                // 返回false则Phaser继续工作
                return true;
            }
        };

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    if ("2".equals(Thread.currentThread().getName())) {
                        TimeUnit.SECONDS.sleep(5);
                    }
                    System.out.println(Thread.currentThread().getName() + " begin at " + phaser.getPhase());
                    phaser.arriveAndAwaitAdvance();
                    System.out.println(Thread.currentThread().getName() + " end at " + phaser.getPhase());

                    System.out.println(Thread.currentThread().getName() + " begin at " + phaser.getPhase());
                    phaser.arriveAndAwaitAdvance();
                    System.out.println(Thread.currentThread().getName() + " end at " + phaser.getPhase());

                    System.out.println(Thread.currentThread().getName() + " begin at " + phaser.getPhase());
                    phaser.arriveAndAwaitAdvance();
                    System.out.println(Thread.currentThread().getName() + " end at " + phaser.getPhase());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, i + 1 + "").start();
        }
    }
}
