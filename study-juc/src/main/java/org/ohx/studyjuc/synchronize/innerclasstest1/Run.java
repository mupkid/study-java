package org.ohx.studyjuc.synchronize.innerclasstest1;

/**
 * @author mudkip
 * @date 2022/6/23
 */
public class Run {
    public static void main(String[] args) {
        OutClass.InnerClass1 innerClass1 = new OutClass.InnerClass1();
        OutClass.InnerClass2 innerClass2 = new OutClass.InnerClass2();

        new Thread(() -> {
            innerClass1.method1(innerClass2);
        }, "T1").start();

        new Thread(() -> {
            innerClass1.method2();
        }, "T2").start();

        new Thread(() -> {
            innerClass2.method1();
        }, "T3").start();
    }
}
