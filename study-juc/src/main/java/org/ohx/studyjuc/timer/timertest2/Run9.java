package org.ohx.studyjuc.timer.timertest2;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * schedule方法不具有追赶性
 *
 * @author mudkip
 * @date 2022/7/5
 */
public class Run9 {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        System.out.println("now time " + System.currentTimeMillis());

        long schedule = now - 20000;
        System.out.println("schedule time " + System.currentTimeMillis());

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("begin timer = " + System.currentTimeMillis());
                System.out.println("end timer = " + System.currentTimeMillis());
            }
        }, new Date(schedule), 3000);
    }
}
