package org.ohx.studyjuc.waitnotify.waitnotifybase;

/**
 * @author mudkip
 * @date 2022/6/24
 */
public class Thread1 extends Thread {
    private Object lock;

    public Thread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("Start wait " + System.currentTimeMillis());
                lock.wait();
                System.out.println("end wait " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
