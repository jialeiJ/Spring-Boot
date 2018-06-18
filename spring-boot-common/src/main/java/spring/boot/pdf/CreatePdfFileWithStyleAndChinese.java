package spring.boot.pdf;

import java.awt.Color;
import java.io.FileOutputStream;

import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Section;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

/**
 * 创建一个带有样式和输出中文内容的pdf文件
 *
 */
public class CreatePdfFileWithStyleAndChinese {

	public static void main(String[] args) throws Exception {
		//创建文件
		Document document = new Document();
		
		//建立书写器
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Administrator/Desktop/HelloWorld.pdf"));
		
		//打开文件
		document.open();
		
		//中文字体，解决中文不能显示的问题
		BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		//蓝色字体
		Font blueFont = new Font(bfChinese);
		blueFont.setColor(Color.blue);
		//段落文本
		Paragraph paragraph = new Paragraph("中华人民共和国paragraphOne blue front", blueFont);
		document.add(paragraph);
		
		//绿色字体
		Font greenFont = new Font(bfChinese);
		greenFont.setColor(Color.GREEN);
		//创建章节
		Paragraph chapterTitle = new Paragraph("段落标题*****", greenFont);
		Chapter chapter = new Chapter(chapterTitle, 1);
		chapter.setNumberDepth(0);
		
		Paragraph sectionTitle = new Paragraph("部分标题", greenFont);
		Section section = chapter.addSection(sectionTitle);
		Paragraph sectionContent = new Paragraph("部分内容", blueFont);
		section.add(sectionContent);
		
		//将章节添加到文章中
		document.add(chapter);
		
		//关闭文档
		document.close();
		
		//关闭书写器
		writer.close();
	}

}
