package spring.boot.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//单元格中使用换行
public class DTextWrap {

	public static void main(String[] args) throws Exception {
		
		Workbook workbook = new HSSFWorkbook();//创建新的工作簿
		Sheet sheet = workbook.createSheet();//创建sheet页
		Row row = sheet.createRow(2);//创建一行
		Cell cell = row.createCell(2);
		cell.setCellValue("我要换行\n成功了吗?");
		
		CellStyle cellStyle = workbook.createCellStyle();
		//设置可以换行
		cellStyle.setWrapText(true);
		cell.setCellStyle(cellStyle);
		
		//调整行的高度
		row.setHeightInPoints(2*sheet.getDefaultRowHeightInPoints());
		//调整单元格宽度
		sheet.setDefaultColumnWidth(2*sheet.getDefaultColumnWidth());
		
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\工作簿.xls");
		workbook.write(fos);
		fos.close();
	}
}
