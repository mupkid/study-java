package org.ohx.studyjuc.forkjoin.recursiveactiondemo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author mudkip
 * @date 2022/7/14
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new MyRecursiveAction(1, 10));
        Thread.sleep(5000);
    }
}

class MyRecursiveAction extends RecursiveAction {
    private int beginValue;
    private int endValue;

    public MyRecursiveAction(int beginValue, int endValue) {
        super();
        this.beginValue = beginValue;
        this.endValue = endValue;
    }

    @Override
    protected void compute() {
        System.out.println(Thread.currentThread().getName() + " -------");
        if (endValue - beginValue > 2) {
            int middelNum = (beginValue + endValue) / 2;
            MyRecursiveAction leftAction = new MyRecursiveAction(beginValue, middelNum);
            MyRecursiveAction rightAction = new MyRecursiveAction(middelNum + 1, endValue);
            this.invokeAll(leftAction, rightAction);
        } else {
            System.out.println("打印组合为：" + beginValue + "-" + endValue);
        }
    }
}