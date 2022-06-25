package org.ohx.studyjuc.join.jointest2;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class Run1 {
    public static void main(String[] args) throws InterruptedException {
        ThreadB threadB = new ThreadB();
        ThreadA threadA = new ThreadA(threadB);
        threadA.start();
        threadB.start();
        // join方法需要抢ThreadB对象锁
        threadB.join(200);

        System.out.println("main end " + System.currentTimeMillis());
    }
}
