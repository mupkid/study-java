package org.ohx.studyjuc.reentrantlock.readwritelock;

/**
 * @author mudkip
 * @date 2022/6/27
 */
public class ReadWrite {
    public static void main(String[] args) {
        Service service = new Service();
        new Thread(() -> {
            service.read();
        }).start();
        new Thread(() -> {
            service.write();
        }).start();
        new Thread(() -> {
            service.read();
        }).start();
        new Thread(() -> {
            service.write();
        }).start();
    }
}
