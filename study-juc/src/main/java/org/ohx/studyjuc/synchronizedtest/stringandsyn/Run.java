package org.ohx.studyjuc.stringandsyn;

/**
 * @author mudkip
 * @date 2022/6/23
 */
public class Run {
    public static void main(String[] args) {
        new Thread(() -> {
            Service.print("aa");
        }, "A").start();

        new Thread(() -> {
            Service.print("aa");
        }, "B").start();
    }
}
