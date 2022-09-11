package org.ohx.studyjuc.timer.demo1;

import java.util.Date;
import java.util.Timer;

/**
 * 基本使用，定时任务线程不销毁
 *
 * @author mudkip
 * @date 2022/7/4
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("当前时间为：" + start);
        long scheduleTime = start + 10000;
        System.out.println("计划时间为：" + scheduleTime);

        TaskA task = new TaskA();

        Timer timer = new Timer();
        Thread.sleep(1000);
        timer.schedule(task, new Date(scheduleTime));
    }
}
