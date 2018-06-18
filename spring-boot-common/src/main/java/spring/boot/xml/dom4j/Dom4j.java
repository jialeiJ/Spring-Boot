package spring.boot.xml.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4j {

	public static void main(String[] args) throws Exception {
		read();
		write();
	}

	private static void read() throws DocumentException {
		//创建SAXReader对象
		SAXReader saxReader = new SAXReader();
		//通过saxReader对象的read()方法加载xml文件,获取Document
		Document document = saxReader.read(new File("books.xml"));
		//通过document对象获取根节点bookstore
		Element bookStore = document.getRootElement();
		//通过element对象的elementIterator()方法获取迭代器
		Iterator iterator = bookStore.elementIterator();
		//遍历迭代器,获取根节点中的信息(书籍)
		while(iterator.hasNext()) {
			System.out.println("/**********************遍历书籍开始***********************/");
			Element book = (Element) iterator.next();
			//获取book的属性名以及属性值
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attribute : bookAttrs) {
				System.out.println("属性名: "+attribute.getName() +"  属性值: "+attribute.getValue());
			}
			
			Iterator it = book.elementIterator();
			while(it.hasNext()) {
				Element bookChild = (Element) it.next();
				System.out.println("节点名: "+bookChild.getName() +"  节点值: "+bookChild.getText()+"  "+bookChild.getStringValue());
			}
			System.out.println("/**********************遍历书籍结束***********************/");
		}
	}
	
	private static void write() throws DocumentException {
		//创建SAXReader对象
		SAXReader saxReader = new SAXReader();
		//通过saxReader对象的read()方法加载xml文件,获取Document
		Document document = saxReader.read(new File("books.xml"));
		//通过document对象获取根节点bookstore
		Element bookStore = document.getRootElement();
		//通过element对象的elementIterator()方法获取迭代器
		Iterator iterator = bookStore.elementIterator();
		//遍历迭代器,获取根节点中的信息(书籍)
		while(iterator.hasNext()) {
			System.out.println("/**********************遍历书籍开始***********************/");
			Element book = (Element) iterator.next();
			//获取book的属性名以及属性值
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attribute : bookAttrs) {
				System.out.println("属性名: "+attribute.getName() +"  属性值: "+attribute.getValue());
			}
					
			Iterator it = book.elementIterator();
			while(it.hasNext()) {
				Element bookChild = (Element) it.next();
				System.out.println("节点名: "+bookChild.getName() +"  节点值: "+bookChild.getText()+"  "+bookChild.getStringValue());
			}
			System.out.println("/**********************遍历书籍结束***********************/");
		}
	}

}
