package org.ohx.studyjuc.reentrantlock.reentrantlocktest;

/**
 * @author mudkip
 * @date 2022/6/26
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();

        new Thread(() -> {
            service.testMethod();
        }).start();

        new Thread(() -> {
            service.testMethod();
        }).start();

        new Thread(() -> {
            service.testMethod();
        }).start();

        new Thread(() -> {
            service.testMethod();
        }).start();

        new Thread(() -> {
            service.testMethod();
        }).start();
    }
}
