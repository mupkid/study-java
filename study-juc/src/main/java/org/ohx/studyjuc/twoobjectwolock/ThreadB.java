package org.ohx.studyjuc.twoobjectwolock;

/**
 * @author mudkip
 * @date 2022/6/22
 */
public class ThreadB extends Thread {
    private HasSelfPrivateNum num;

    public ThreadB(HasSelfPrivateNum num) {
        super();
        this.num = num;
    }

    @Override
    public void run() {
        super.run();
        num.addI("b");
    }
}
