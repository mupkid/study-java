package org.ohx.studyjuc.synchronizedtest;

/**
 * @author mudkip
 * @date 2022/9/14
 */
public class LockSyncDemo {
    Object object = new Object();

    public synchronized static void m1() {
        System.out.println("---hell synchronized method");
    }
}
