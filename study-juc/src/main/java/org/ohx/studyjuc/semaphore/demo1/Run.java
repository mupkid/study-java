package org.ohx.studyjuc.semaphore.demo1;

/**
 * @author mudkip
 * @date 2022/7/11
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                service.method1();
            }, i + 1 + "").start();
        }
    }
}
