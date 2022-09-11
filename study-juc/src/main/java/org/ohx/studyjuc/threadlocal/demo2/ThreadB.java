package org.ohx.studyjuc.threadlocal.demo2;

/**
 * @author mudkip
 * @date 2022/6/26
 */
public class ThreadB extends Thread {
    @Override
    public void run() {
        try {
//            for (int i = 0; i < 10; i++) {
//                Tools.t1.set("B " + i);
//                System.out.println("B get" + Tools.t1.get());
//                Thread.sleep((int) (Math.random() * 1000));
//            }

            for (int i = 1; i < 10; i++) {
                if (Tools.t1.get() == null) {
                    Tools.t1.set("B " + i);
                }
                System.out.println("B get" + Tools.t1.get());
                Thread.sleep((int) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
