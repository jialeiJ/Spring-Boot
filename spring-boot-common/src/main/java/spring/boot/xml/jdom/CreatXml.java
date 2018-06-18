package spring.boot.xml.jdom;
import java.io.FileOutputStream;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;
//JDOM缺点---不能格式化
public class CreatXml {

	public static void main(String[] args) throws Exception {
		Element xml  = new Element("student");//创建节点
		//定义属性
		Attribute id = new Attribute("id", "001");
		
		xml.setAttribute(id);
		
		//定义节点
		Element name = new Element("name");
		//为节点赋值
		name.setText("张三");
		xml.addContent(name);
		Element sex = new Element("sex");
		sex.setText("男");
		xml.addContent(sex);
		Element age = new Element("age");
		age.setText("20");
		xml.addContent(age);
		
		//创建根节点
		Document document = new Document(xml);
		//xml输出器
		XMLOutputter xmlOutputter = new XMLOutputter();
		//设置格式
		xmlOutputter.setFormat(xmlOutputter.getFormat().setEncoding("UTF-8"));
		
		xmlOutputter.output(document, new FileOutputStream("src/student.xml"));	
	}
}