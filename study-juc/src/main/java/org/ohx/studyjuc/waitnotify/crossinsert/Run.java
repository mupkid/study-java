package org.ohx.studyjuc.waitnotify.crossinsert;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class Run {
    public static void main(String[] args) {
        DBTools dbTools = new DBTools();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                dbTools.backupA();
            }, "A" + i).start();
            new Thread(() -> {
                dbTools.backupB();
            }, "B" + i).start();
        }
    }
}
