package spring.boot.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class ZipFileTest {

	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();//获取当前时间
		
		
		String fromFile = "C:/Users/Administrator/Desktop/test/";//被压缩文件的路径
		String toFile = "C:/Users/Administrator/Desktop/test/zip/zip.zip";//压缩文件的存放路径
		
		File file = new File(fromFile);
		File[] files = file.listFiles();//获取所有文件集合
		
		FileInputStream fis = null;
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(toFile));
		
		for (File f : files) {
			if(!f.isDirectory()){
				fis = new FileInputStream(fromFile+f.getName());
				ZipEntry ze = new ZipEntry(f.getName());
				zos.putNextEntry(ze);
				byte[] buffer = new byte[4096];
				int count = 0;
				while((count=fis.read(buffer))>0){
					zos.write(buffer, 0, count);
				}
			}
		}
		
		zos.closeEntry();
		zos.close();
		fis.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间："+(endTime-startTime)+"ms");
	}
}
