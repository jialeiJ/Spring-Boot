package spring.boot.poi;

import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//单元格对齐方式
public class CCellAlign {

	public static void main(String[] args) throws Exception {
		
		Workbook workbook = new HSSFWorkbook();//创建新的工作簿
		Sheet sheet = workbook.createSheet();//创建sheet页
		Row row = sheet.createRow(2);//创建一行
		row.setHeightInPoints(30);
		
		createCell(workbook, row, (short)0, HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_BOTTOM);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\工作簿.xls");
		workbook.write(fos);
		fos.close();

	}
	
	/**
	 * 创建一个单元格并为其设置指定的对齐方式
	 * @param workbook 工作簿
	 * @param row 行
	 * @param column 列
	 * @param halign 水平方向对齐方式
	 * @param valign 垂直方向对齐方式
	 */
	private static void createCell(Workbook workbook,Row row,short column,short halign,short valign) {
		Cell cell = row.createCell(column);//创建单元格
		cell.setCellValue(new HSSFRichTextString("Align It"));//设置值
		CellStyle cellStyle = workbook.createCellStyle();//创建单元格样式
		cellStyle.setAlignment(halign);//设置单元格水平方向对齐方式
		cellStyle.setVerticalAlignment(valign);//设置单元格垂直方向对齐方式
		cell.setCellStyle(cellStyle);//设置单元格样式
	}
}
