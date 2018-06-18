package spring.boot.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

//单元格填充色与颜色操作
public class CCellFillCorlorAndColorOperation {

	public static void main(String[] args) throws Exception {
		
		Workbook workbook = new HSSFWorkbook();//创建新的工作簿
		Sheet sheet = workbook.createSheet();//创建sheet页
		Row row = sheet.createRow(1);//创建一行
		Cell cell = row.createCell(1);
		cell.setCellValue("你好");
		
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());//底部边框
		cellStyle.setFillPattern(CellStyle.BIG_SPOTS);
		cell.setCellStyle(cellStyle);
		
		
		Cell cell2 = row.createCell(2);
		cell2.setCellValue("HelloWorld");
		CellStyle cellStyle2 = workbook.createCellStyle();
		cellStyle2.setFillForegroundColor(IndexedColors.RED.getIndex());
		cellStyle2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell2.setCellStyle(cellStyle2);
		
		
		
		
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\工作簿.xls");
		workbook.write(fos);
		fos.close();
	}
}
