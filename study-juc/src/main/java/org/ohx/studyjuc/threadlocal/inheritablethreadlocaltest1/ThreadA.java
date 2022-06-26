package org.ohx.studyjuc.threadlocal.inheritablethreadlocaltest1;

/**
 * @author mudkip
 * @date 2022/6/26
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在线程A中取值=" + Tools.t1.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
