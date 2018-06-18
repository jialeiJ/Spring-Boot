package spring.boot.xml.dom4j;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class CreateXmlByDOM4J {
	public static void main(String[] args) throws Exception {
		Document document = DocumentHelper.createDocument();
		//添加元素节点
		Element studentElement = document.addElement("student");
		//添加属性节点
		studentElement.addAttribute("id", "001");
		studentElement.addAttribute("hh", "哈哈");
		//添加元素子节点
		Element name = studentElement.addElement("name");
		//赋值
		name.setText("zhangsan");
		Element sex = studentElement.addElement("sex");
		sex.setText("女");
		Element age = studentElement.addElement("age");
		age.setText("30");
		
		//输出
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/student.xml"),format);
		writer.write(document);
		writer.close();	
	}
}
