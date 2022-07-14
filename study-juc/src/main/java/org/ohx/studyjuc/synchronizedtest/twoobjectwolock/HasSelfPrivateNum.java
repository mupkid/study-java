package org.ohx.studyjuc.synchronizedtest.twoobjectwolock;

/**
 * @author mudkip
 * @date 2022/6/22
 */
public class HasSelfPrivateNum {
    private int num = 0;

    synchronized public void addI(String username) {
        if (username.equals("a")) {
            num = 100;
            System.out.println("a set over!");
        } else {
            num = 200;
            System.out.println("b set over!");
        }
        System.out.println(username + " num=" + num);
    }
}
