package spring.boot.xml.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Dom {

public static void main(String[] args) throws Exception {
		
		//解析xml文件的属性名与属性值
		Document document = init();
		//通过标签名获取元素放入节点的集合中-----<book id="1">(开始标签)</book>(结束标签)
		NodeList bookList = document.getElementsByTagName("book");
		System.out.println("一共有  "+bookList.getLength()+" 本书");
		
		//遍历book节点
		for (int i = 0; i < bookList.getLength(); i++) {
			//通过item()方法获取book节点, 索引值从0开始
			Node book = bookList.item(i);
			//遍历book属性, 获取所有属性集合
			NamedNodeMap attrs =  book.getAttributes();
			System.out.println("第  "+(i+1)+" 本书共有  "+attrs.getLength()+" 个属性");
			
			//遍历book的属性
			for(int j = 0; j < attrs.getLength(); j++) {
				//通过item()方法获取book节点的某个属性
				Node attr = attrs.item(j);
				//获取属性名及属性值
				System.out.println("属性名: "+attr.getNodeName()+"---属性值: "+attr.getNodeValue());
				
			}
		}

	}
	
	public static Document init() throws Exception {
		//创建DocumentBuilderFactory对象
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		//创建DocumentBuilder对象
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		//通过DocumentBuilder对象的parse方法加载xml文件到当前项目下
		Document document = documentBuilder.parse("books.xml");
		return document;
	}


}
