package org.ohx.studyjuc.waitnotify.waitOld;

/**
 * @author mudkip
 * @date 2022/6/24
 */
public class Add {
    private String lock;

    public Add(String lock) {
        super();
        this.lock = lock;
    }

    public void add() {
        synchronized (lock) {
            ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }
}
