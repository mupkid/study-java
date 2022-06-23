package org.ohx.studyjuc.syntwolock;

/**
 * @author mudkip
 * @date 2022/6/22
 */
public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        Service.printA();
    }
}
