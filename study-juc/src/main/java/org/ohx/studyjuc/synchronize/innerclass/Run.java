package org.ohx.studyjuc.synchronize.innerclass;

/**
 * @author mudkip
 * @date 2022/6/23
 */
public class Run {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        publicClass.setUsername("username");
        publicClass.setPassword("password");
        System.out.println(publicClass.getUsername() + " " + publicClass.getPassword());

        PublicClass.PrivateClass privateClass = publicClass.new PrivateClass();
        privateClass.setAge("age");
        privateClass.setAddress("address");
        System.out.println(privateClass.getAge() + " " + privateClass.getAddress());
    }
}
