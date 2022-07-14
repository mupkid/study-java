package org.ohx.studyjuc.timer.timertest1;

import java.util.TimerTask;

/**
 * @author mudkip
 * @date 2022/7/4
 */
public class TaskA extends TimerTask {
    @Override
    public void run() {
        System.out.println("任务执行了，时间为：" + System.currentTimeMillis());
    }
}
