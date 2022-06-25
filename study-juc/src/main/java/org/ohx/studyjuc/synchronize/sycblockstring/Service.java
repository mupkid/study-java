package org.ohx.studyjuc.synchronize.sycblockstring;

/**
 * @author mudkip
 * @date 2022/6/22
 */
public class Service {
    private String username;
    private String password;

    public void setUsernamePassword(String username, String password) {
        try {
            String anyString = new String();
            synchronized (anyString) {
                System.out.println(
                    "Thread name " + Thread.currentThread().getName() + " enter at " + System.currentTimeMillis());
                username = username;
                Thread.sleep(3000);
                password = password;
                System.out.println(
                    "Thread name " + Thread.currentThread().getName() + " leave at " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
