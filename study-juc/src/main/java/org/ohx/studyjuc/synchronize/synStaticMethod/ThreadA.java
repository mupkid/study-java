package org.ohx.studyjuc.synchronize.synStaticMethod;

/**
 * @author mudkip
 * @date 2022/6/22
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        Service.printA();
    }
}
