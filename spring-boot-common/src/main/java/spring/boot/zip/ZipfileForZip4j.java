package spring.boot.zip;

import java.io.File;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ZipfileForZip4j {

	public static void main(String[] args) {
		String password = "123456";
		String srcPath = "C:/Users/Administrator/Desktop/test/";
		String toPath = "C:/Users/Administrator/Desktop/test/zip/zip.zip";
		
		createZipOfEncrypt(password, srcPath, toPath);

	}

	/**
	 * 生成带有加密功能的压缩包
	 * @param password 加密密码
	 * @param srcPath  文件夹源路径
	 * @param toPath  压缩文件路径
	 */
	public static void createZipOfEncrypt(String password, String srcPath,
			String toPath) {
		try {
            if(!new File(srcPath).exists()) {
                System.out.println("源路径不存在 "+srcPath);
            }
            ZipParameters parameters = new ZipParameters();  
            parameters.setEncryptFiles(true);  
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);  
            parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);  
            parameters.setPassword(password.toCharArray());  
            File srcFile = new File(srcPath);
            ZipFile toFile = new ZipFile(toPath);  
            if(srcFile.isDirectory()) {
                 toFile.addFolder(srcFile, parameters);  
            } else {
                toFile.addFile(srcFile, parameters); 
            }
            System.out.println("成功加密文件");
        } catch (Exception e) {
            System.out.println("加密文件发生异常:"+e);
        }
	}
}
