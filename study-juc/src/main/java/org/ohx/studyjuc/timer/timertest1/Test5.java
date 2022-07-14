package org.ohx.studyjuc.timer.timertest1;

import java.util.Date;
import java.util.Timer;

/**
 * @author mudkip
 * @date 2022/7/4
 */
public class Test5 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("当前时间为：" + start);
        long scheduleTime1 = start;
        long scheduleTime2 = start + 5000;
        System.out.println("计划时间1为：" + scheduleTime1);
        System.out.println("计划时间2为：" + scheduleTime2);

        TaskB taskB = new TaskB();
        TaskC taskC = new TaskC();
        Timer timer = new Timer();
        timer.schedule(taskB, new Date(scheduleTime1));
        timer.schedule(taskC, new Date(scheduleTime2));
    }
}
