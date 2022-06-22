package org.ohx.studyjuc.sycblockstring;

/**
 * @author mudkip
 * @date 2022/6/22
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
