package org.ohx.studyjuc.syntwolock;

/**
 * @author mudkip
 * @date 2022/6/23
 */
public class ThreadC extends Thread {
    private Service service;

    public ThreadC(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.printC();
    }
}
