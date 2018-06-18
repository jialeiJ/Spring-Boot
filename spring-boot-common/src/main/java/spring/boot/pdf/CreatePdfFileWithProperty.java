package spring.boot.pdf;

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

/**
 *创建一个带有文件属性的pdf文件
 */
public class CreatePdfFileWithProperty {

	public static void main(String[] args) throws Exception {
		//创建文件
		Document document = new Document();
		
		//建立一个书写器
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Administrator/Desktop/HelloWorld.pdf"));
		
		//打开文件
		document.open();
		
		//添加内容
		document.add(new Paragraph("Some content here"));
		
		//设置属性
		document.addTitle("This is a title");//标题
		document.addAuthor("Jaray");//作者
		document.addSubject("This is subject");//主题
		document.addKeywords("Keywords");//关键字
		document.addCreationDate();//创建时间
		document.addCreator("hd.com");//应用程序
		
		//关闭文档
		document.close();
		
		//关闭书写器
		writer.close();
	}
}
