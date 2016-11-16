package com.gqx.SAXParser;

import java.io.File;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Demo2 {

	public static void main(String[] args) throws Exception, SAXException {
		// TODO Auto-generated method stub
		//创建SAXParser对象
		SAXParser parser=SAXParserFactory.newInstance().newSAXParser();
		
		MyDH2 myDH2=new MyDH2();
		
		parser.parse(new File("./src/contact.xml"), myDH2);
		
		System.out.println(myDH2.getContacts());
	}
}
