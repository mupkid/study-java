package org.ohx.studyjuc.lock.reentrantlock.fairnofairtest;

import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/6/27
 */
public class Run2 {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service(false);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                service.testMethod();
            }, "A" + i).start();
        }
        TimeUnit.MILLISECONDS.sleep(500);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                service.testMethod();
            }, "B" + i).start();
        }
    }
}
