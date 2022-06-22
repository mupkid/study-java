package org.ohx.studyjuc.ThreadPoolExecutor;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("定制线程名" + Math.random());
        return thread;
    }

}
