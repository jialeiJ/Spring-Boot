package spring.boot.poi;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//文本提取
public class BTextGet {

	public static void main(String[] args) throws Exception {
		
		InputStream is = new FileInputStream("C:\\Users\\Administrator\\Desktop\\工作簿.xls");
		POIFSFileSystem fs = new POIFSFileSystem(is);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fs);
		
		ExcelExtractor excelExtractor = new ExcelExtractor(hssfWorkbook);
		System.out.println(excelExtractor.getText());
	}
}
