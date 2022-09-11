package org.ohx.studyjuc.join.demo2;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class RunFirst {
    public static void main(String[] args) {
        ThreadB threadB = new ThreadB();
        ThreadA threadA = new ThreadA(threadB);
        threadA.start();
        threadB.start();
        System.out.println("main end " + System.currentTimeMillis());
    }
}
