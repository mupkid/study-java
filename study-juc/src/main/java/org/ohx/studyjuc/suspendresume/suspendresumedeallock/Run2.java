package org.ohx.studyjuc.suspendresume.suspendresumedeallock;

/**
 * 主线程结束后，MyThread处于暂停状态并未销毁，整个进程没有停止销毁
 *
 * @author mudkip
 * @date 2022/6/22
 */
public class Run2 {
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
            }
        }
    }
}