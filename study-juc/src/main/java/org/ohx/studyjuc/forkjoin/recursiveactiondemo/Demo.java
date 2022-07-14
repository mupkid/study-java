package org.ohx.studyjuc.forkjoin.recursiveactiondemo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author mudkip
 * @date 2022/7/14
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(new RecursiveAction() {
            @Override
            protected void compute() {
                System.out.println("compute run");
            }
        });
        Thread.sleep(5000);
    }
}
