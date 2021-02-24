import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class LambdaTest {

	/**
	 * 无参函数接口
	 */
	void test1() {
		//匿名内部类
		new Thread(new Runnable() {  //接口名
			@Override
			public void run() {    //方法名
				System.out.println("Thread start!");
			}
		}).start();

		//lambda写法，省略了接口名和方法名，单行方法可省略大括号
		new Thread(() -> System.out.println("Thread start!")).start();

		//lambda写法，省略了接口名和方法名，多行方法保留大括号
		new Thread(() -> {
			System.out.println("Thread start");
			System.out.println("Thread start");
		}).start();
	}

	/**
	 * 有参函数接口
	 */
	void test2() {
		//匿名内部类
		List<String> list = Arrays.asList("I", "love", "you", "too");
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1 == null) {
					return -1;
				}
				if (s2 == null) {
					return 1;
				}
				return s1.length() - s2.length();
			}
		});

		//Lambda表达式，省略了接口名、方法名和参数的类型
		Collections.sort(list, (s1, s2) -> {
			if (s1 == null) {
				return -1;
			}
			if (s2 == null) {
				return 1;
			}
			return s1.length() - s2.length();
		});
	}

	/**
	 * 更多用法
	 */
	void test3() {
		Runnable run = () -> System.out.println("Hello World!");
		ActionListener listener = event -> System.out.println("button clicked");
		Runnable multiLine = () -> {
			System.out.println("Hello");
			System.out.println(" World!");
		};
		BinaryOperator<Long> add = (Long x, Long y) -> x + y;
		BinaryOperator<Long> addImplicit = (x, y) -> x + y;
		BinaryOperator<Long> addAnotherImplicit = Long::sum;
	}
}
