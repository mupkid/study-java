package org.ohx.studyjuc.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author mudkip
 * @date 2022/9/18
 */
public class AtomicBooleanInterrupt {
    static AtomicBoolean isStop = new AtomicBoolean(false);

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                if (isStop.get()) {
                    System.out.println(Thread.currentThread().getName() + " isStop 被修改为 true，程序停止");
                    break;
                }
                System.out.println("t1 --- hello AtomicBoolean");
            }
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            isStop.set(true);
        }, "t2").start();
    }
}
