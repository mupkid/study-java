package org.ohx.studyjuc.synchronizedtest.syntwolock;

/**
 * @author mudkip
 * @date 2022/6/22
 */
public class Service {
    synchronized public static void printA() {
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

    synchronized public static void printB() {
        System.out.println(
            "Thread " + Thread.currentThread().getName() + " enter printB at " + System.currentTimeMillis());
        System.out.println(
            "Thread " + Thread.currentThread().getName() + " leave printB at " + System.currentTimeMillis());
    }

    synchronized public void printC() {
        System.out.println(
            "Thread " + Thread.currentThread().getName() + " enter printC at " + System.currentTimeMillis());
        System.out.println(
            "Thread " + Thread.currentThread().getName() + " leave printC at " + System.currentTimeMillis());
    }
}
