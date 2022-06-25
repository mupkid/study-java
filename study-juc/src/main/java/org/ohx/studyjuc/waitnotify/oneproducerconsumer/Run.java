package org.ohx.studyjuc.waitnotify.oneproducerconsumer;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class Run {
    public static void main(String[] args) {
        String lock = new String("");
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);

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
}
