package spring.boot.poi;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

//遍历工作簿的行和列并获取其内容
public class BEachExcel {

	public static void main(String[] args) throws Exception {
		
		InputStream is = new FileInputStream("C:\\Users\\Administrator\\Desktop\\工作簿.xls");
		POIFSFileSystem fs = new POIFSFileSystem(is);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fs);
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);//获取第一个sheet页
		if(hssfSheet!=null) {
			//遍历行
			for(int rowNum=0;rowNum<=hssfSheet.getLastRowNum();rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if(hssfRow==null) {
					continue;
				}
				//遍历列Cell
				for(int cellNum=0;cellNum<=hssfRow.getLastCellNum();cellNum++) {
					HSSFCell hssfCell = hssfRow.getCell(cellNum);
					if(hssfCell==null) {
						continue;
					}
					System.out.print(hssfCell+"\t");
				}
				System.out.println();
			}
		}
	}
}
