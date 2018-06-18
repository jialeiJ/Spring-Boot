package spring.boot.poi;

import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

//处理不同内容格式的单元格
public class BHandleStyleCell {

	public static void main(String[] args) throws Exception {
		
		Workbook workbook = new HSSFWorkbook();//创建新的工作簿
		Sheet sheet = workbook.createSheet();//创建sheet页
		Row row = sheet.createRow(0);//创建一行
		Cell cell = row.createCell(0);//创建一列
		cell.setCellValue(new Date());//为单元格设值
		
		row.createCell(1).setCellValue(1);
		row.createCell(2).setCellValue("一个字符串");
		row.createCell(3).setCellValue(true);
		row.createCell(4).setCellValue(HSSFCell.CELL_TYPE_NUMERIC);
		row.createCell(5).setCellValue(false);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\工作簿.xls");
		workbook.write(fos);
		fos.close();
	}
}
