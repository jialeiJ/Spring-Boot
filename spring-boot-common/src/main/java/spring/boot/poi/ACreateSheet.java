package spring.boot.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
//创建sheet页
public class ACreateSheet {
	
	public static void main(String[] args) throws Exception {
		
		Workbook workbook = new HSSFWorkbook();//创建新的工作簿
		workbook.createSheet("sheetOne");//创建sheet页，sheetOne为sheet页的名称
		workbook.createSheet("sheetTwo");//
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\用poi创建的sheet页.xls");
		workbook.write(fos);
		fos.close();
	}
}

