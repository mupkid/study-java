package org.ohx.studyjuc.timer.timertest2;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * schedule方法 任务不延时
 *
 * @author mudkip
 * @date 2022/7/4
 */
public class Run2 {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        System.out.println("now time " + System.currentTimeMillis());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println("begin timer = " + System.currentTimeMillis());
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("end timer = " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 3000, 4000);
    }
}
