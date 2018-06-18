package spring.boot.xml.dom4j;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParseXmlByDOM4J {
	public static void main(String[] args) throws Exception {
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read("src/students.xml");
		//获取根节点
		Element rootElement = document.getRootElement();
		Iterator iter = rootElement.elementIterator();
		while(iter.hasNext()) {
			Element studentElement = (Element) iter.next();
			System.out.println("学号："+studentElement.attributeValue("id"));
			System.out.println("姓名："+studentElement.elementText("name"));
			System.out.println("性别："+studentElement.elementText("sex"));
			System.out.println("年龄："+studentElement.elementText("age"));
			System.out.println("-------------------------------------------");
		}
	}
}