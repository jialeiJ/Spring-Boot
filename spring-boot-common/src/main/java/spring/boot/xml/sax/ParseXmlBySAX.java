package spring.boot.xml.sax;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//优点：消耗资源较少，适合大文件解析
//缺点：只能读取不能修改，开发复杂
public class ParseXmlBySAX extends DefaultHandler {
	private List<Student> students = null;
	private Student student = null;
	private String preTag = null;//标记上一个节点名称

	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		
		ParseXmlBySAX parseXmlBySAX = new ParseXmlBySAX();
		
		parser.parse("src/students.xml", parseXmlBySAX);
		
		System.out.println(parseXmlBySAX.students);

	}
	
	

	//扫描节点开始的事件
	@Override
	public void startDocument() throws SAXException {
		System.out.println("开始读取学生信息");
		students = new ArrayList<Student>();
		
	}

	//扫描节点结束的事件
	@Override
	public void endDocument() throws SAXException {
		System.out.println("学生信息读取完毕");
	}

	//扫描元素开始的事件
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if("student".equals(qName)) {
			student = new Student();
			student.setId(attributes.getValue(0));
		}
		preTag = qName;//给标记赋值
		System.out.println(qName);
	}

	//扫描元素结束的事件
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if("student".equals(qName)) {
			students.add(student);
			student = null;
		}
		preTag = null;
	}

	//扫描文本内容的事件
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(preTag!=null) {
			String context = new String(ch, start, length);
			if("name".equals(preTag)) {
				student.setName(context);
			}else if("sex".equals(preTag)) {
				student.setSex(context);
			}else if("age".equals(preTag)) {
				student.setAge(context);
			}
		}
	}
}
