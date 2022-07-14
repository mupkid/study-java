package org.ohx.studyjuc.timer.timertest1;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/7/4
 */
public class TaskB extends TimerTask {
    @Override
    public void run() {
        try {
            System.out.println("B Begin Timer " + System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(20);
            System.out.println("B End Timer " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
