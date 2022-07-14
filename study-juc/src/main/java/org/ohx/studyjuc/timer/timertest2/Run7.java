package org.ohx.studyjuc.timer.timertest2;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * scheduleAtFixedRate方法 延时
 *
 * @author mudkip
 * @date 2022/7/5
 */
public class Run7 {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        System.out.println("now time " + System.currentTimeMillis());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println("begin timer = " + System.currentTimeMillis());
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("end timer = " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, new Date(now), 2000);
    }
}
