package org.ohx.studyjuc.timer.demo1;

import java.util.Date;
import java.util.Timer;

/**
 * 在一个 Timer 中执行多个 TimerTask
 *
 * @author mudkip
 * @date 2022/7/4
 */
public class Test4 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("当前时间为：" + start);
        long scheduleTime1 = start + 5000;
        long scheduleTime2 = start + 8000;
        System.out.println("计划时间为：" + scheduleTime1);
        System.out.println("计划时间为：" + scheduleTime2);

        TaskA task1 = new TaskA();
        TaskA task2 = new TaskA();
        Timer timer = new Timer();
        timer.schedule(task1, new Date(scheduleTime1));
        timer.schedule(task2, new Date(scheduleTime2));
    }
}
