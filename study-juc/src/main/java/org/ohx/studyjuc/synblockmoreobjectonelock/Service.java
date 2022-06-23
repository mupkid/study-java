package org.ohx.studyjuc.synblockmoreobjectonelock;

/**
 * @author mudkip
 * @date 2022/6/23
 */
public class Service {
    public static void printA() {
        synchronized (Service.class) {
            try {
                System.out.println(
                    "Thread " + Thread.currentThread().getName() + " enter printA at " + System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println(
                    "Thread " + Thread.currentThread().getName() + " leave printA at " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printB() {
        synchronized (Service.class) {
            System.out.println(
                "Thread " + Thread.currentThread().getName() + " enter printB at " + System.currentTimeMillis());
            System.out.println(
                "Thread " + Thread.currentThread().getName() + " leave printB at " + System.currentTimeMillis());
        }
    }
}
