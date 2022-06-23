package org.ohx.studyjuc.synStaticMethod;

/**
 * @author mudkip
 * @date 2022/6/23
 */
public class ThreadB extends Thread {
    @Override
    public void run() {
        Service.printB();
    }
}
