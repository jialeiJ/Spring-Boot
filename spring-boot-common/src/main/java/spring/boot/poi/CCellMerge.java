package spring.boot.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

//单元格合并
public class CCellMerge {

	public static void main(String[] args) throws Exception {
		
		Workbook workbook = new HSSFWorkbook();//创建新的工作簿
		Sheet sheet = workbook.createSheet();//创建sheet页
		Row row = sheet.createRow(1);//创建一行
		Cell cell = row.createCell(1);
		cell.setCellValue("单元格合并测试");
		
		sheet.addMergedRegion(new CellRangeAddress(
				1,//起始行
				2,//结束行
				1,//起始列
				2 //结束列
				));
		
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\工作簿.xls");
		workbook.write(fos);
		fos.close();
	}
}
