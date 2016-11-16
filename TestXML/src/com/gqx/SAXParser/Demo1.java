package com.gqx.SAXParser;

import java.io.File;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Demo1 {

	public static void main(String[] args) throws Exception, SAXException {
		// TODO Auto-generated method stub
		//创建SAXParser对象
		SAXParser parser=SAXParserFactory.newInstance().newSAXParser();
		
		//调用parse方法
		/*
		 * 参数一：xml文档
		 * 参数二：DefaultHander的子类
		 */
		Mydh mydh=new Mydh();
		parser.parse(new File("./src/contact.xml"), mydh);
		String string=mydh.getContent();
		System.out.println(string);
	}

}
