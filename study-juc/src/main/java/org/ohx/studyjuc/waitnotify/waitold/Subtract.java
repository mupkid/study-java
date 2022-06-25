package org.ohx.studyjuc.waitnotify.waitold;

/**
 * @author mudkip
 * @date 2022/6/24
 */
public class Subtract {
    private String lock;

    public Subtract(String lock) {
        super();
        this.lock = lock;
    }

    public void subtract() {
        try {
            synchronized (lock) {
                // 用if会有异常
                //  if (ValueObject.list.size() == 0) {
                while (ValueObject.list.size() == 0) {
                    System.out.println("wait begin Thread " + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait end Thread " + Thread.currentThread().getName());
                }
                ValueObject.list.remove(0);
                System.out.println("list size " + ValueObject.list.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
