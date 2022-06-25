package org.ohx.studyjuc.suspendresume.suspendresumedeallock;

/**
 * 暂停线程后，仍然持有锁
 *
 * @author mudkip
 * @date 2022/6/22
 */
public class Run1 {
    public static void main(String[] args) {
        try {
            final SynchronizedObject object = new SynchronizedObject();

            new Thread(object::printString, "a").start();

            Thread.sleep(1000);

            new Thread(object::printString, "b").start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SynchronizedObject {
    synchronized public void printString() {
        System.out.println(Thread.currentThread().getName() + " begin");
        Thread.currentThread().suspend();
        System.out.println("end");
    }
}
