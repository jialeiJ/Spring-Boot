package spring.boot.pdf;

import java.io.FileOutputStream;

import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

/**
 * 修改已有的pdf文件
 */
public class UpdatePdfFile {

	public static void main(String[] args) throws Exception {
		//读取pdf文件
		PdfReader reader = new PdfReader("C:/Users/Administrator/Desktop/HelloWorld.pdf");
		
		//修改器
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("C:/Users/Administrator/Desktop/Hello.pdf"));
		
		Image image = Image.getInstance("C:/Users/Administrator/Desktop/8032=.jpg");
		image.scaleAbsolute(50, 50);
		image.setAbsolutePosition(0, 700);
		
		for(int i=1;i<=reader.getNumberOfPages();i++){
			PdfContentByte content = stamper.getUnderContent(i);
			content.addImage(image);
		}
		stamper.close();
	}
}