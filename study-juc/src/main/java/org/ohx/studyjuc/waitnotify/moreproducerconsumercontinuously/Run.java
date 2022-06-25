package org.ohx.studyjuc.waitnotify.moreproducerconsumercontinuously;

import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Box box = new Box();
        SetService setService = new SetService(box);
        GetService getService = new GetService(box);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    setService.setMethod();
                }
            }, "SetThread" + i).start();
        }
        TimeUnit.MILLISECONDS.sleep(50);
        new Thread(() -> {
            setService.checkBoxStatus();
        }).start();

        TimeUnit.SECONDS.sleep(10);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    getService.getMethod();
                }
            }, "GetThread" + i).start();
        }
        TimeUnit.MILLISECONDS.sleep(50);
        new Thread(() -> {
            getService.checkBoxStatus();
        }).start();
    }
}
