package org.ohx.studyjuc.synchronize.synblockmoreobjectonelock;

/**
 * @author mudkip
 * @date 2022/6/23
 */
public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        Service.printB();
    }
}
