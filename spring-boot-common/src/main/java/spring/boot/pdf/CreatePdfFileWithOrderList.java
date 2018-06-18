package spring.boot.pdf;

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

/**
 * 创建一个带有有序列表的pdf文件
 */
public class CreatePdfFileWithOrderList {

	public static void main(String[] args) throws Exception {
		//创建文件
		Document document = new Document();
		
		//建立书写器
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Administrator/Desktop/HelloWorld.pdf"));
		
		//打开文件
		document.open();
		
		//添加内容
		document.add(new Paragraph("HD content here"));
		
		//添加有序列表
		List orderedList = new List(List.ORDERED);
		orderedList.add(new ListItem("Item one"));
		orderedList.add(new ListItem("Item two"));
		orderedList.add(new ListItem("Item three"));
		document.add(orderedList);
		
		//关闭文档
		document.close();
		
		//关闭书写器
		writer.close();
	}

}
