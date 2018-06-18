package spring.boot.pdf;

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

/**
 * 创建一个简单的pdf文件
 */
public class CreatePdfFile {

	public static void main(String[] args) throws Exception {
		//1.新建document对象
		Document document = new Document();
				
		//2.建立书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Administrator/Desktop/HelloWorld.pdf"));
				
		//3.打开文档
		document.open();
				
		//4.添加一个内容段落
		document.add(new Paragraph("Hello World"));
				
		//5.关闭文档
		document.close();
				
		//关闭书写器
		writer.close();
	}

}
