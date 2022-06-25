package org.ohx.studyjuc.waitnotify.moreproducerconsumer;

import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    producer.setValue();
                }
            }, "producer").start();

            new Thread(() -> {
                while (true) {
                    consumer.getValue();
                }
            }, "consumer").start();
        }

        TimeUnit.SECONDS.sleep(5);
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for (Thread thread : threads) {
            System.out.println(thread.getName() + " " + thread.getState());
        }
    }
}
