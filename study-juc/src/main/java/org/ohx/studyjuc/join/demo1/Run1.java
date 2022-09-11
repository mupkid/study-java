package org.ohx.studyjuc.join.demo1;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class Run1 {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                int secondValue = (int) (Math.random() * 10000);
                System.out.println(secondValue);
                Thread.sleep(secondValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Thread.sleep(?)
        System.out.println("main线程想实现当threadTest对象执行完毕后我再继续向下执行,");
        System.out.println("但上面代码中的sleep()中的值应该写多少呢？");
        System.out.println("答案是：不能确定");
    }
}