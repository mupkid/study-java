package org.ohx.studyjuc.lock.fairnofairtest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mudkip
 * @date 2022/6/27
 */
public class Service {
    private Lock lock;

    public Service(boolean fair) {
        lock = new ReentrantLock(fair);
    }

    public void testMethod() {
        try {
            lock.lock();
            System.out.println("testMethod " + Thread.currentThread().getName());
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
