package spring.boot.poi;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

//创建时间格式的单元格
public class BCreateTimeFormatCell {

	public static void main(String[] args) throws Exception {
		Workbook workbook = new HSSFWorkbook();//创建新的工作簿
		Sheet sheet = workbook.createSheet();//创建一个sheet页
		Row row = sheet.createRow(0);//创建一行
		Cell cell = row.createCell(0);//创建一个单元格，第一列
		cell.setCellValue(new Date());//为单元格设置值
		
		CreationHelper creationHelper = workbook.getCreationHelper();
		CellStyle cellStyle = workbook.createCellStyle();//创建单元格样式
		cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd:hh:mm"));
		cell = row.createCell(1);//第二列
		cell.setCellValue(new Date());//设值
		cell.setCellStyle(cellStyle);//应用时间日期格式
		
		cell = row.createCell(2);//第三列
		cell.setCellValue(Calendar.getInstance());
		cell.setCellStyle(cellStyle);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\工作簿.xls");
		workbook.write(fos);
		fos.close();
	}
}
