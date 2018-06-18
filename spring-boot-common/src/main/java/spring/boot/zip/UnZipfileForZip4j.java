package spring.boot.zip;

import java.io.File;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class UnZipfileForZip4j {

	public static void main(String[] args) {
		String password = "123456";
		String toPath = "C:/Users/Administrator/Desktop/test/zip/";
		String srcPath = "C:/Users/Administrator/Desktop/test/zip/zip.zip";
		
		try {
            if(!new File(srcPath).exists()) {
                System.out.println("源路径不存在 "+srcPath);
            }
            ZipFile srcFile = new ZipFile(srcPath);  
            srcFile.setFileNameCharset("UTF-8");  
            srcFile.setPassword(password.toCharArray());  
            srcFile.extractAll(toPath);
            System.out.println("成功解密文件");
       } catch (ZipException e) {
           System.out.println("解密文件发生异常:"+e);
       }
	}
}