package spring.boot.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.tomcat.util.security.MD5Encoder;

public class ShiroTest {

	public static void main(String[] args) {
		//SimpleHash hash = new SimpleHash("MD5", password,salt,2);
		Md5Hash mmhash = new Md5Hash("123456","admin8d78869f470951332959580424d4bf4f",2);//数据库密码加密d3c59d25033dbf980d29554025c23a75
		System.out.println(mmhash);
		Md5Hash yzhash = new Md5Hash("admin","admin");//数据库盐值
		System.out.println(yzhash);
		
	}

}
