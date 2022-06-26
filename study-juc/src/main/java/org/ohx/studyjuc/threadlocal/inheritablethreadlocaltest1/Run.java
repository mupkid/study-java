package org.ohx.studyjuc.threadlocal.inheritablethreadlocaltest1;

/**
 * @author mudkip
 * @date 2022/6/26
 */
public class Run {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                if (Tools.t1.get() == null) {
                    Tools.t1.set("此值是main线程放入的！");
                }
                System.out.println("在main线程中取值=" + Tools.t1.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            new ThreadA().start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
