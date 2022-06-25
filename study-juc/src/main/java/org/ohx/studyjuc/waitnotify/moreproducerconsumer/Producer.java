package org.ohx.studyjuc.waitnotify.moreproducerconsumer;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class Producer {
    private String lock;

    public Producer(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                while (!"".equals(ValueObject.value)) {
                    System.out.println("Producer " + Thread.currentThread().getName() + " waiting");
                    lock.wait();
                }
                System.out.println("Producer " + Thread.currentThread().getName() + " running");
                ValueObject.value = System.currentTimeMillis() + "_" + System.nanoTime();
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
