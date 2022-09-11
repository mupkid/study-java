package org.ohx.studyjuc.lock.reentrantlock.useconditionwaitnotify;

import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/6/27
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        new Thread(() -> {
            service.await();
        }).start();

        TimeUnit.SECONDS.sleep(3);
        service.signal();
    }
}
