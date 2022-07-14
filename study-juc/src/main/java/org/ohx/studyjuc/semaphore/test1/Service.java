package org.ohx.studyjuc.semaphore.test1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/7/11
 */
public class Service {
    private Semaphore semaphore = new Semaphore(1);

    public void method1() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " begin timer=" + System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() + " end timer=" + System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
