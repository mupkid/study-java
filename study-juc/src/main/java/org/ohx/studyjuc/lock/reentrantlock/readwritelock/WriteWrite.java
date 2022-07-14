package org.ohx.studyjuc.lock.reentrantlock.readwritelock;

/**
 * @author mudkip
 * @date 2022/6/27
 */
public class WriteWrite {
    public static void main(String[] args) {
        Service service = new Service();
        new Thread(() -> {
            service.write();
        }).start();
        new Thread(() -> {
            service.write();
        }).start();
    }
}
