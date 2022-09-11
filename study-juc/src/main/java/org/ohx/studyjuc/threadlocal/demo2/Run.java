package org.ohx.studyjuc.threadlocal.demo2;

/**
 * @author mudkip
 * @date 2022/6/26
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();

//        for (int i = 0; i < 10; i++) {
//            Tools.t1.set("main " + i);
//            System.out.println("main get " + Tools.t1.get());
//            Thread.sleep((int) (Math.random() * 1000));
//        }
        for (int i = 2; i < 10; i++) {
            if (Tools.t1.get() == null) {
                Tools.t1.set("main " + i);
            }
            System.out.println("main get" + Tools.t1.get());
            Thread.sleep((int) (Math.random() * 1000));
        }
    }
}
