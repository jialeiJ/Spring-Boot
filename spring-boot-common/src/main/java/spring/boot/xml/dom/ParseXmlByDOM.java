package spring.boot.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
//将xml文档加载在内存中(适用于小文件)
public class ParseXmlByDOM {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/students.xml");
		//获取students元素节点集合
		NodeList nodeList = document.getElementsByTagName("students");
		//得到students
		Element element = (Element) nodeList.item(0);
		//获取student元素节点集合
		NodeList students = element.getElementsByTagName("student");
		for(int i=0; i<students.getLength(); i++) {
			Element studentElement = (Element) students.item(i);
			//打印属性节点
			for(int j=0; j<students.item(i).getAttributes().getLength(); j++) {
				System.out.println(students.item(i).getAttributes().item(j).getNodeName()+"---"+students.item(i).getAttributes().item(j).getNodeValue());
			}
			
			
			//打印name元素节点内的文本节点
			System.out.println("姓名："+studentElement.getElementsByTagName("name").item(0).getFirstChild().getTextContent());
			System.out.println("性别："+studentElement.getElementsByTagName("sex").item(0).getFirstChild().getNodeValue());
			System.out.println("年龄："+studentElement.getElementsByTagName("age").item(0).getFirstChild().getNodeValue());
			System.out.println("--------------------------------------");
		}
	}
}