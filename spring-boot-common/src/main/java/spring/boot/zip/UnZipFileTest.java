package spring.boot.zip;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class UnZipFileTest {

	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();//获取当前时间
		
		
		String path = "C:/Users/Administrator/Desktop/test/zip/zip.zip";
		File file = new File(path);
		ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
		BufferedInputStream bis = new BufferedInputStream(zis);
		FileOutputStream fos = null;
		ZipEntry zipEntry = null;
		
		if(!(new File("C:/Users/Administrator/Desktop/test/zip/zip").exists())){
			new File("C:/Users/Administrator/Desktop/test/zip/zip").mkdirs();
		}
		
		
		byte[] buffer = new byte[4096];
		int count = 0;
		while((zipEntry=zis.getNextEntry())!=null){
			fos = new FileOutputStream(new File("C:/Users/Administrator/Desktop/test/zip/zip/"+zipEntry.getName()));
			
			while((count=bis.read(buffer))>0){
				fos.write(buffer, 0, count);
			}
		}
		
		fos.close();
		zis.close();
		bis.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间："+(endTime-startTime)+"ms");	
	}
}