import java.util.Date;

public class GenericTest<T> {
    public static void main(String[] args) {
        Class clazz=Integer.class;
        System.out.println(clazz.getCanonicalName());
        clazz=String.class;
        System.out.println(clazz.getCanonicalName());
        clazz= Date.class;
        System.out.println(clazz.getCanonicalName());
    }
}
