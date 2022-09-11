package org.ohx.studyjuc.timer.demo1;

import java.util.Date;
import java.util.Timer;

/**
 * 基本使用，定时任务线程销毁
 *
 * @author mudkip
 * @date 2022/7/4
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("当前时间为：" + start);
        long scheduleTime = start + 10000;
        System.out.println("计划时间为：" + scheduleTime);

        TaskA task = new TaskA();
        Timer timer = new Timer();
        timer.schedule(task, new Date(scheduleTime));

        Thread.sleep(18000);
        // 使用cancel方法销毁TimerThread线程
        timer.cancel();
    }
}
