package spring.boot.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

//创建自定义数据格式
public class DCreateCustomDataFormat {

	public static void main(String[] args) throws Exception {
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		CellStyle cellStyle;
		DataFormat dataFormat = workbook.createDataFormat();
		Row row;
		Cell cell;
		short rowNum = 0;
		short colNum = 0;
		
		row = sheet.createRow(rowNum++);
		cell = row.createCell(colNum);
		cell.setCellValue(111111.25);
		
		cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(dataFormat.getFormat("0.0"));//设置数据格式
		cell.setCellStyle(cellStyle);
		
		
		row = sheet.createRow(rowNum++);
		cell = row.createCell(colNum);
		cell.setCellValue(111111.25);
		cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(dataFormat.getFormat("#,##0.000"));//设置数据格式
		cell.setCellStyle(cellStyle);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\工作簿.xls");
		workbook.write(fos);
		fos.close();

	}
}