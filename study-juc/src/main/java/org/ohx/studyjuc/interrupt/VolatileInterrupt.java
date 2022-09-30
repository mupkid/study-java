package org.ohx.studyjuc.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/9/18
 */
public class VolatileInterrupt {
    static volatile boolean isStop = false;

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                if (isStop) {
                    System.out.println(Thread.currentThread().getName() + " isStop 被修改为 true，程序停止");
                    break;
                }
                System.out.println("t1 --- hello volatile");
            }
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            isStop = true;
        }, "t2").start();
    }
}
