package spring.boot.pdf;

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

/**
 * 创建一个带有密码的pdf文件
 */
public class CreatePdfFileWhitPassword {

	public static void main(String[] args) throws Exception {
		//创建文件
		Document document = new Document();
		
		//建立书写器
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Administrator/Desktop/HelloWorld.pdf"));
		
		//用户密码
		String userPassword = "123456";
		
		//拥有者密码
		String ownerPassword = "hd";
		writer.setEncryption(userPassword.getBytes(), ownerPassword.getBytes(), PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING,PdfWriter.STANDARD_ENCRYPTION_40);
		
		//打开文件
		document.open();
		
		//添加内容
		document.add(new Paragraph("password!!!!!"));
		
		//关闭文档
		document.close();
		
		//关闭书写器
		writer.close();

	}

}
