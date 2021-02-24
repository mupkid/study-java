import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PersonManager<T> {
    private Map<Integer, T> map = new HashMap<Integer, T>();

    public void add(T t) throws Exception {
        Scanner input = new Scanner(System.in);
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("请输入 " + field.getName() + ":");
            Object value = null;
            if (field.getType().equals(String.class)) {
                value = input.next();
            } else if (field.getType().equals(Integer.class)) {
                value = input.nextInt();
            } else if (field.getType().equals(Float.class)) {
                value = input.nextFloat();
            } else if (field.getType().equals(Double.class)) {
                value = input.nextDouble();
            } else if (field.getType().equals(Boolean.class)) {
                value = input.nextBoolean();
            }

            String setterName = "set"
                    + field.getName().substring(0, 1).toUpperCase()
                    + field.getName().substring(1);
            Method method = clazz.getMethod(setterName, field.getType());
            method.invoke(t, value);
        }
        Method method = clazz.getDeclaredMethod("getID");
        map.put((Integer) method.invoke(t), t);
    }

    public void remove(T t) throws Exception {
        Method method = t.getClass().getDeclaredMethod("getID");
        map.remove((Integer) method.invoke(t));
    }

    public void findByID(Integer ID) throws Exception {
        System.out.println(map.get(ID));
    }

    public void update(T t) throws Exception {
        Method method = t.getClass().getDeclaredMethod("getID");
        System.out.println(map.get((Integer)method.invoke(t)));
        remove(t);
        add(t);
    }
    public void findAll() {
        Set<Map.Entry<Integer,T>> entrySet = map.entrySet();
        for(Map.Entry<Integer, T> entry:entrySet) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
