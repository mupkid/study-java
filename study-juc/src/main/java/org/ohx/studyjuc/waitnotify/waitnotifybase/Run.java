package org.ohx.studyjuc.waitnotify.waitnotifybase;

import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/6/24
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        new Thread1(lock).start();
        TimeUnit.SECONDS.sleep(3);
        new Thread2(lock).start();
    }
}
