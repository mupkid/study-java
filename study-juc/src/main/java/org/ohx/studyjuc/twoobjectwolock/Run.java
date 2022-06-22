package org.ohx.studyjuc.twoobjectwolock;

/**
 * @author mudkip
 * @date 2022/6/22
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum num1 = new HasSelfPrivateNum();
        HasSelfPrivateNum num2 = new HasSelfPrivateNum();

        new ThreadA(num1).start();
        new ThreadB(num2).start();
    }
}
