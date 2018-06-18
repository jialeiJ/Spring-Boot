package spring.boot.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//单元格边框处理
public class CHandleBorder {

	public static void main(String[] args) throws Exception {
		
		Workbook workbook = new HSSFWorkbook();//创建新的工作簿
		Sheet sheet = workbook.createSheet();//创建sheet页
		Row row = sheet.createRow(2);//创建一行
		Cell cell = row.createCell(3);
		cell.setCellValue("你好");
		
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);//底部边框
		cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());//底部边框颜色
		
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);//左边边框
		cellStyle.setLeftBorderColor(IndexedColors.GREEN.getIndex());//底部边框颜色
		
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);//右边边框
		cellStyle.setRightBorderColor(IndexedColors.BLUE.getIndex());//底部边框颜色
		
		cellStyle.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);//顶部边框
		cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());//顶部边框颜色
		
		cell.setCellStyle(cellStyle);
		
		
		
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\工作簿.xls");
		workbook.write(fos);
		fos.close();
	}
}
