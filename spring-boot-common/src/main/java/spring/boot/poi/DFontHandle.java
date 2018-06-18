package spring.boot.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

//字体处理
public class DFontHandle {

	public static void main(String[] args) throws Exception {
		
		Workbook workbook = new HSSFWorkbook();//定义新的工作簿
		Sheet sheet = workbook.createSheet();//创建sheet页
		Row row = sheet.createRow(1);//创建一行
		
		//创建字体对象
		Font font = workbook.createFont();
		font.setFontHeightInPoints((short)24);//设置字体高度
		font.setFontName("Courier New");//设置字体名称
		font.setItalic(true);//斜体
		font.setStrikeout(true);//删除线
		
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFont(font);
		
		Cell cell = row.createCell(1);
		cell.setCellValue("This is test of fonts");
		cell.setCellStyle(cellStyle);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\工作簿.xls");
		workbook.write(fos);
		fos.close();
	}
}