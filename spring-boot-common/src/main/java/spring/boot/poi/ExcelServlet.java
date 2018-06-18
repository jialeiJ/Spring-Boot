package spring.boot.poi;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

@WebServlet("/ExcelServlet")
public class ExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取数据
		String result = request.getParameter("result");
		//将数据分行
		String[] rows = result.split(";");
		//创建新的工作簿
		Workbook workbook = new HSSFWorkbook();
		//创建sheet页
		Sheet sheet = workbook.createSheet();
		for (int i = 0; i < rows.length; i++) {
			String col = rows[i];
			String[] cols = col.split(",");
			Row row = sheet.createRow(i);//创建一行
			for (int j = 0; j < cols.length; j++) {
				String string2 = cols[j];
				System.out.println(string2);
				
				Cell cell = row.createCell(j);//创建单元格，第一列
				cell.setCellValue(string2);//为单元格设置值
				
				
			}
		}
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\用poi创建的cell单元格.xls");
		workbook.write(fos);
		fos.close();
		
		
		
		/*Workbook workbook = new HSSFWorkbook();//创建新的工作簿
		Sheet sheet = workbook.createSheet();//创建sheet页
		Row row = sheet.createRow(0);//创建一行
		Cell cell = row.createCell(0);//创建单元格，第一列
		cell.setCellValue("你好");//为单元格设置值
		
		row.createCell(1).setCellValue(1.2);//创建一个单元格，第二列值是1.2
		
		row.createCell(2).setCellValue("字符串类型");//创建一个单元格，第三列值是字符串类型
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\用poi创建的cell单元格.xls");
		workbook.write(fos);
		fos.close();*/
	}
}
