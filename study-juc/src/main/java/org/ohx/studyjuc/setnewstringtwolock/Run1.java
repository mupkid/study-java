package org.ohx.studyjuc.setnewstringtwolock;

/**
 * @author mudkip
 * @date 2022/6/23
 */
public class Run1 {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        Thread a = new Thread(() -> {
            service.testMethod();
        }, "A");

        Thread b = new Thread(() -> {
            service.testMethod();
        }, "B");

        a.start();
        Thread.sleep(50);
        b.start();
    }
}
