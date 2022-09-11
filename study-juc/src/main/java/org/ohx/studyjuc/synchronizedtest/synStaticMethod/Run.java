package org.ohx.studyjuc.synchronizedtest.synStaticMethod;

/**
 * @author mudkip
 * @date 2022/6/23
 */
public class Run {
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB();
        b.setName("B");
        b.start();
    }
}
