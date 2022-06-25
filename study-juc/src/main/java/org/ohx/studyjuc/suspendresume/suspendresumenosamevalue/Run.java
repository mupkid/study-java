package org.ohx.studyjuc.suspendresume.suspendresumenosamevalue;

/**
 * @author mudkip
 * @date 2022/6/22
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        final MyObject myObject = new MyObject();
        new Thread(() -> myObject.setValue("a", "aa"), "a").start();
        Thread.sleep(1000);
        new Thread(() -> myObject.printUsernamePassword(), "b").start();
    }
}

class MyObject {
    private String username = "1";
    private String password = "11";

    public void setValue(String u, String p) {
        this.username = u;
        Thread.currentThread().suspend();
        this.password = p;
    }

    public void printUsernamePassword() {
        System.out.println(username + " " + password);
    }
}
