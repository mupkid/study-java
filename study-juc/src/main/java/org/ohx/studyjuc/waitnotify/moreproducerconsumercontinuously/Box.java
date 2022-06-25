package org.ohx.studyjuc.waitnotify.moreproducerconsumercontinuously;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class Box {
    private static final List<Object> LIST = new ArrayList<>();

    synchronized public void add() {
        if (size() < 50) {
            LIST.add("anyString");
            System.out.println("Thread " + Thread.currentThread().getName() + " excute add, size is " + size());
        }
    }

    synchronized public int size() {
        return LIST.size();
    }

    synchronized public Object popFirst() {
        Object value = LIST.remove(0);
        System.out.println("Thread " + Thread.currentThread().getName() + " excute popFirst, size is " + size());
        return value;
    }
}
