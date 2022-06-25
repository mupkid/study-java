package org.ohx.studyjuc.waitnotify.waitOld;

/**
 * @author mudkip
 * @date 2022/6/24
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");

        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);

        new Thread(() -> {
            subtract.subtract();
        }, "subtract1Thread").start();

        new Thread(() -> {
            subtract.subtract();
        }, "subtract2Thread").start();

        new Thread(() -> {
            add.add();
        }, "addThread").start();

        Thread.sleep(1000);
    }
}
