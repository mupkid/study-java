package org.ohx.studyjuc.synchronize.setnewstringtwolock;

/**
 * @author mudkip
 * @date 2022/6/23
 */
public class Run2 {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        new Thread(() -> {
            service.testMethod();
        }, "A").start();

        new Thread(() -> {
            service.testMethod();
        }, "B").start();
    }
}