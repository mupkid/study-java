import java.util.Scanner;

public class PersonUI {
    PersonManager<Person> manager = new PersonManager<Person>();

    public static int selectFunction() {
        Scanner input = new Scanner(System.in);
        System.out.println("请选择功能：");
        System.out.println("1~~~~~~新增");
        System.out.println("2~~~~~~删除");
        System.out.println("3~~~~~~查询");
        System.out.println("4~~~~~~更改信息");
        System.out.println("5~~~~~~显示所有信息");
        System.out.println("0~~~~~~退出");
        int chioce = input.nextInt();
        return chioce;
    }

    public static void search(PersonManager manager) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要查询的Id号：");
        Integer id = input.nextInt();
        manager.findByID(id);
    }

    public static void upData(PersonManager manager, Class clazz)
            throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要更改的人的ID：");
        Integer ID = input.nextInt();
        Person person = (Person) clazz.newInstance();
        clazz.getDeclaredMethod("setID", Integer.class).invoke(person, ID);
        manager.update(person);
    }

    public static void remove(PersonManager manager, Class clazz)
            throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要删除的人的ID：");
        Integer ID = input.nextInt();
        Person person = (Person) clazz.newInstance();
        clazz.getDeclaredMethod("setID", Integer.class).invoke(person, ID);
        manager.remove(person);
    }

    public static void main(String[] args) throws Exception {
        PersonManager<Person> manager = new PersonManager<Person>();
        System.out.println("输入类名:");
        Scanner input = new Scanner(System.in);
        String className = input.next();
        Class clazz = Class.forName(className);
        Person person = (Person) clazz.newInstance();
        int select = selectFunction();
        while (select != 0) {
            switch (select) {
                case 1:
                    manager.add(person);
                    System.out
                            .println("************************************************");
                    break;
                case 2:
                    remove(manager, clazz);
                    System.out
                            .println("************************************************");
                    break;
                case 3:
                    search(manager);
                    System.out
                            .println("************************************************");
                    break;
                case 4:
                    upData(manager, clazz);
                    System.out
                            .println("************************************************");
                    break;
                case 5:
                    manager.findAll();
                    System.out
                            .println("************************************************");
                    break;

            }
            select = selectFunction();
        }

    }
}
