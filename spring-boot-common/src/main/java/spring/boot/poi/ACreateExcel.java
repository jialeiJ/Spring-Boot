package spring.boot.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
//创建Excel工作簿
public class ACreateExcel {
	
	public static void main(String[] args) throws Exception {
		Workbook workbook = new HSSFWorkbook();//定义新的工作簿
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\用poi创建的工作簿.xls");
		workbook.write(fos);
		fos.close();
	}
}

