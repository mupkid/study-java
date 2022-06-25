package org.ohx.studyjuc.innerclasstest1;

import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/6/23
 */
public class OutClass {
    static class InnerClass1 {
        public void method1(InnerClass2 class2) {
            String threadName = Thread.currentThread().getName();
            synchronized (class2) {
                System.out.println(threadName + " enter InnerClass1.method1");
                for (int i = 1; i <= 10; i++) {
                    System.out.println("i=" + i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(threadName + " leave InnerClass1.method1");
            }
        }

        public synchronized void method2() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " enter InnerClass1.method2");
            for (int j = 1; j <= 10; j++) {
                System.out.println("j=" + j);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " leave InnerClass1.method2");
        }
    }

    static class InnerClass2 {
        public synchronized void method1() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " enter InnerClass2.method1");
            for (int k = 1; k <= 10; k++) {
                System.out.println("k=" + k);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " leave InnerClass2.method1");
        }
    }
}
