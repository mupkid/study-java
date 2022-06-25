package org.ohx.studyjuc.join.jointest2;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class ThreadB extends Thread {
    @Override
    synchronized public void run() {
        // 进入方法需要抢ThreadB对象锁
        try {
            System.out.println(
                "begin B Thread=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(500);
            System.out.println(
                "end B Thread=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
