package org.ohx.studyjuc.timer.timertest1;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/7/4
 */
public class TaskC extends TimerTask {
    @Override
    public void run() {
        try {
            System.out.println("C Begin Timer " + System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(5);
            System.out.println("C End Timer " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
