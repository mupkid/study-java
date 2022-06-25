package org.ohx.studyjuc.synchronize.twoobjectwolock;

/**
 * @author mudkip
 * @date 2022/6/22
 */
public class ThreadA extends Thread {
    private HasSelfPrivateNum num;

    public ThreadA(HasSelfPrivateNum num) {
        super();
        this.num = num;
    }

    @Override
    public void run() {
        super.run();
        num.addI("a");
    }
}
