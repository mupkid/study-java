package org.ohx.studyjuc.join.jointest2;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class ThreadA extends Thread {
    private ThreadB b;

    public ThreadA(ThreadB b) {
        this.b = b;
    }

    @Override
    public void run() {
        try {
            synchronized (b) {
                // 进入同步块需要抢ThreadB对象锁
                System.out.println(
                    "begin A Thread=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(500);
                System.out.println(
                    "end A Thread=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
