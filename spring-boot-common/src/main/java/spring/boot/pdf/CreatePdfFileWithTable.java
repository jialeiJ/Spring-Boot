package spring.boot.pdf;

import java.awt.Color;
import java.io.FileOutputStream;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPRow;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 * 创建一个带有表格的pdf文件
 */
public class CreatePdfFileWithTable {

	public static void main(String[] args) throws Exception {
		//创建文件
		Document document = new Document();
		
		//建立书写器
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Administrator/Desktop/HelloWorld.pdf"));
		
		//打开文件
		document.open();
		
		//添加内容
		document.add(new Paragraph("HD content here"));
		
		//定义一个具有3列的表格
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100);//设置100%填充
		table.setSpacingBefore(10f);//设置前间距
		table.setSpacingAfter(10f);//设置后间距

		List<PdfPRow> listRow = table.getRows();
		
		//设置列宽
		float[] columnWidths = {1f,2f,3f};
		table.setWidths(columnWidths);
		
		//行一
		PdfPCell cells1[] = new PdfPCell[3];
		PdfPRow row1 = new PdfPRow(cells1);
		
		//单元格
		cells1[0] = new PdfPCell(new Paragraph("111"));//设置单元格内容
		
		//cells1[0].setBorderColor(BaseColor.BLUE);//边框验证
		cells1[0].setBorderColor(Color.BLUE);;//边框验证
		cells1[0].setPaddingLeft(20);//左填充20
		cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
		cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
		
		cells1[1] = new PdfPCell(new Paragraph("222"));
		cells1[2] = new PdfPCell(new Paragraph("333"));
		
		//行二
		PdfPCell cells2[] = new PdfPCell[3];
		PdfPRow row2 = new PdfPRow(cells2);
		cells2[0] = new PdfPCell(new Paragraph("444"));
		
		//把第一行添加到集合中
		listRow.add(row1);
		listRow.add(row2);
		//把表格添加到文件中
		document.add(table);
		
		//关闭文档
		document.close();
		
		//关闭书写器
		writer.close();
	}
}