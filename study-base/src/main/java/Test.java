import java.io.File;

public class Test {

	public static void main(String[] args) {

		// File.separator 获取使用程序所运行平台的文件分隔符
		System.out.println(File.separator);
		System.out.println(File.pathSeparator);

		// java.io中的类将相对路径名解释为以用户工作目录开始，通过System.getProperty("user.dir")获得该信息
		System.out.println(System.getProperty("user.dir"));
	}
}
