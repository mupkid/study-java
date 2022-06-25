package org.ohx.studyjuc.waitnotify.moreproducerconsumer;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class Consumer {
    private String lock;

    public Consumer(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                while ("".equals(ValueObject.value)) {
                    System.out.println("Consumer " + Thread.currentThread().getName() + " waiting");
                    lock.wait();
                }
                System.out.println("Consumer " + Thread.currentThread().getName() + " running");
                ValueObject.value = "";
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
