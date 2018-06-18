package spring.boot.poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//读取并重写工作簿
public class DReadAndOverwrite {

	public static void main(String[] args) throws Exception {
		
		InputStream is = new FileInputStream("C:\\Users\\Administrator\\Desktop\\工作簿.xls");
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(is);
		Workbook workbook = new HSSFWorkbook(poifsFileSystem);
		Sheet sheet = workbook.getSheetAt(0);//获取第一个sheet页
		Row row = sheet.createRow(0);//获取第一行
		Cell cell = row.getCell(0);//获取单元格
		if(cell==null) {
			cell = row.createCell(3);
		}
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue("测试单元格");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\工作簿.xls");
		workbook.write(fos);
		fos.close();
	}
}
