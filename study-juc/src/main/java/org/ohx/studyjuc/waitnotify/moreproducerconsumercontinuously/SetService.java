package org.ohx.studyjuc.waitnotify.moreproducerconsumercontinuously;

import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class SetService {
    private Box box;

    public SetService(Box box) {
        this.box = box;
    }

    public void setMethod() {
        try {
            synchronized (this) {
                while (box.size() == 50) {
                    System.out.println("-----");
                    this.wait();
                }
            }
            TimeUnit.MILLISECONDS.sleep(300);
            box.add();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkBoxStatus() {
        try {
            while (true) {
                synchronized (this) {
                    if (box.size() < 50) {
                        this.notifyAll();
                    }
                }

                System.out.println("set checkboxBox = " + box.size());
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
