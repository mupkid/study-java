import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class LambdaCollectionTest {
	void test1(){
		//使用增强for循环迭代
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I","love","you","too"));
		for(String str : list){
			if(str.length()>3){
				System.out.println(str);
			}
		}

		//使用forEach()结合匿名内部类
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				if(s.length()>3){
					System.out.println(s);
				}
			}
		});

		//使用Lambda表达式
		list.forEach(s ->{
			if(s.length()>3){
				System.out.println(s);
			}
		});
		list.removeIf(s -> s.length()>3);
		list.replaceAll(s -> {
			if(s.length()>3){
				return s.toUpperCase();
			}
			return s;
		});

	}


}
