package org.ohx.studyjuc.sycblockstring;

/**
 * @author mudkip
 * @date 2022/6/22
 */
public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.setUsernamePassword("b", "bb");
    }
}
