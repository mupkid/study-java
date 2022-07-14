package org.ohx.studyjuc.reentrantlock.conditiontestmoremethod;

/**
 * @author mudkip
 * @date 2022/6/26
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();

        new Thread(() -> {
            service.methodA();
        }, "A").start();


        new Thread(() -> {
            service.methodA();
        }, "AA").start();


        new Thread(() -> {
            service.methodB();
        }, "B").start();


        new Thread(() -> {
            service.methodB();
        }, "BB").start();
    }
}
