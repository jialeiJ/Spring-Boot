package spring.boot.pdf;

import java.io.FileOutputStream;
import java.net.URL;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

/**
 * 创建一个带有图片的pdf文件
 */
public class CreatePdfFileWithImage {

	public static void main(String[] args) throws Exception, DocumentException {
		//创建文件
		Document document = new Document();
		
		//建立一个书写器
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Administrator/Desktop/HelloWorld.pdf"));
		
		//打开文件
		document.open();
		
		//添加内容
		document.add(new Paragraph("HD content here"));
		
//		//图片一
//		Image img = Image.getInstance("C:/Users/Administrator/Desktop/");
//		//设置图片位置的x轴和y轴
//		img.setAbsolutePosition(100f, 550f);
//		//设置图片的宽度和高度
//		img.scaleAbsolute(200, 200);
//		//将图片一添加到pdf文件中
//		document.add(img);
		
		//图片二
		Image image = Image.getInstance(new URL("http://static.cnblogs.com/images/adminlogo.gif"));
		//将图片添加到pdf文件中
		document.add(image);
		
		//关闭文档
		document.close();
		
		//关闭书写器
		writer.close();
	}

}
