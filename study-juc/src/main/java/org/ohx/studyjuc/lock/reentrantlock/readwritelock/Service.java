package org.ohx.studyjuc.lock.reentrantlock.readwritelock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author mudkip
 * @date 2022/6/27
 */
public class Service {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private String username = "abc";

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println("begin read " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            System.out.println("print service " + username);
            TimeUnit.SECONDS.sleep(4);
            System.out.println("end read " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println("begin write " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            username = Thread.currentThread().getName();
            System.out.println("print service " + username);
            TimeUnit.SECONDS.sleep(4);
            System.out.println("end write " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
