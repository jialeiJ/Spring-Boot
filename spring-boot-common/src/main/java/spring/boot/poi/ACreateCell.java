package spring.boot.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//创建单元格
public class ACreateCell {

	public static void main(String[] args) throws Exception {
		
		Workbook workbook = new HSSFWorkbook();//创建新的工作簿
		Sheet sheet = workbook.createSheet();//创建sheet页
		Row row = sheet.createRow(0);//创建一行
		Cell cell = row.createCell(0);//创建单元格，第一列
		cell.setCellValue("你好");//为单元格设置值
		
		row.createCell(1).setCellValue(1.2);//创建一个单元格，第二列值是1.2
		
		row.createCell(2).setCellValue("字符串类型");//创建一个单元格，第三列值是字符串类型
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\用poi创建的cell单元格.xls");
		workbook.write(fos);
		fos.close();
	}
}
