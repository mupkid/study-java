package org.ohx.studyjuc.join.jointest1;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class Run2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                int secondValue = (int) (Math.random() * 10000);
                System.out.println(secondValue);
                Thread.sleep(secondValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();

        System.out.println("我想当threadTest对象执行完毕后我再执行，我做到了");
    }
}