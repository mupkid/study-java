package org.ohx.studyjuc.waitnotify.moreproducerconsumercontinuously;

import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class GetService {
    private Box box;

    public GetService(Box box) {
        this.box = box;
    }

    public void getMethod() {
        try {
            synchronized (this) {
                while (box.size() == 0) {
                    System.out.println("+++++");
                    this.wait();
                }
                box.popFirst();
            }
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkBoxStatus() {
        try {
            while (true) {
                synchronized (this) {
                    if (box.size() > 0) {
                        this.notifyAll();
                    }
                }
                System.out.println("get checkboxBox = " + box.size());
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
