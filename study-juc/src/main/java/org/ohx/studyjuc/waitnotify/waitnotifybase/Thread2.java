package org.ohx.studyjuc.waitnotify.waitnotifybase;

/**
 * @author mudkip
 * @date 2022/6/24
 */
public class Thread2 extends Thread {
    private Object lock;

    public Thread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("Start notify " + System.currentTimeMillis());
            lock.notify();
            System.out.println("end notify " + System.currentTimeMillis());
        }
    }
}
