package spring.boot.utils;

public class Test {

	public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("user.home"));//C:\Users\Administrator
		System.out.println(Test.class.getResource("").toURI().getPath());
	}

}
