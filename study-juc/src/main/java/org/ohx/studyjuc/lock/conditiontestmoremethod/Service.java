package org.ohx.studyjuc.lock.conditiontestmoremethod;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mudkip
 * @date 2022/6/26
 */
public class Service {
    private final Lock lock = new ReentrantLock();

    public void methodA() {
        lock.lock();
        try {
            System.out.println(
                "methodA begin thread " + Thread.currentThread().getName() + " time " + System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(5);
            System.out.println(
                "methodA end thread " + Thread.currentThread().getName() + " time " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            System.out.println(
                "methodB begin thread " + Thread.currentThread().getName() + " time " + System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(5);
            System.out.println(
                "methodB end thread " + Thread.currentThread().getName() + " time " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
