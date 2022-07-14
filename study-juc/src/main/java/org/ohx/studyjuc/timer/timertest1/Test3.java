package org.ohx.studyjuc.timer.timertest1;

import java.util.Date;
import java.util.Timer;

/**
 * 计划时间大于当前时间，定时任务立即执行
 *
 * @author mudkip
 * @date 2022/7/4
 */
public class Test3 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("当前时间为：" + start);
        // 令计划时间大于当前时间
        long scheduleTime = start - 5000;
        System.out.println("计划时间为：" + scheduleTime);

        TaskA task = new TaskA();

        Timer timer = new Timer();
        timer.schedule(task, new Date(scheduleTime));
    }
}
