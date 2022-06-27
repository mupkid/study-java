package org.ohx.studyjuc.lock.reentrantlocktest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mudkip
 * @date 2022/6/26
 */
public class Service {
    private final Lock lock = new ReentrantLock();

    public void testMethod() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + " " + i);
            }
        } finally {
            lock.unlock();
        }
    }
}
