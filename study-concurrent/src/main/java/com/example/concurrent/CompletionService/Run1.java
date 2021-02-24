package com.example.concurrent.CompletionService;

import java.util.concurrent.Callable;

public class Run1 {

    public static void main(String[] args) {

    }

    static class MyCallable implements Callable<String>{
        private String username;
        private long sleepValue;

        public MyCallable(String username, long sleepValue) {
            this.username = username;
            this.sleepValue = sleepValue;
        }

        @Override
        public String call() throws Exception{
            System.out.println(username);
            Thread.sleep(sleepValue);
            return "return "+ username;
        }
    }
}
