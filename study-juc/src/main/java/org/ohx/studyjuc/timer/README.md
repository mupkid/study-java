# 定时器 Timer 学习 Demo

使用 Java API 定时器 Timer 执行定时任务 TimerTask

## Demo1

展示了 Timer 和 TimerTask 的基本使用，错误示例与正确示例。

示例1：错误写法，定时任务线程不销毁。

```java
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
```

示例2：正确写法，定时任务线程销毁。

```java
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
```

## Demo2

`schedule()`方法和`scheduleAtFixedRate()`方法的主要区别在于有没有追赶特性： 当定时任务实际启动时间晚于计划启动时间时，这段丢失的时间内应该执行的任务，`schedule()`是不会执行的；而
`scheduleAtFixedRate()`则会补上。

对于 schedule() 方法：

* 当任务没有被延时执行，则下一次执行开始的时间是上一次任务的开始时间加上period时间（“不延时”是指执行任务的时间小于period间隔时间。）。
* 当任务被延时执行，则下一次任务的执行时间参考的是上一次任务“结束”时的时间来开始（“延时”是指执行任务的时间大于period间隔时间。）。

对于 scheduleAtFixedRate() 方法：

* 当任务没有被延时执行，则下一次执行开始的时间是上一次任务的开始时间加上period时间（“不延时”是指执行任务的时间小于period间隔时间。）。
* 当任务被延时执行，则下一次任务的执行时间参考的是上一次任务“结束”时的时间来开始（“延时”是指执行任务的时间大于period间隔时间。）。
