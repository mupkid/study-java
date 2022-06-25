package org.ohx.studyjuc.suspendresume.suspendresumedeallock;

/**
 * 主线程得不到 println() 方法的锁，导致无法退出
 *
 * @author mudkip
 * @date 2022/6/22
 */
public class Run3 {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.suspend();
            System.out.println("main end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyThread extends Thread {
        private long i = 0;

        @Override
        public void run() {
            while (true) {
                i++;
                System.out.println("i");
            }
        }
    }
}

