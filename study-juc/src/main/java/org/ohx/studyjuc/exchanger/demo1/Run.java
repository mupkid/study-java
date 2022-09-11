package org.ohx.studyjuc.exchanger.demo1;

import java.util.concurrent.Exchanger;

/**
 * @author mudkip
 * @date 2022/7/12
 */
public class Run {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            try {
                System.out.println("线程A得到线程B的值=" + exchanger.exchange("A"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                System.out.println("线程B得到线程A的值=" + exchanger.exchange("B"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
