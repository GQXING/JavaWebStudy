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
		//����SAXParser����
		SAXParser parser=SAXParserFactory.newInstance().newSAXParser();
		
		//����parse����
		/*
		 * ����һ��xml�ĵ�
		 * ��������DefaultHander������
		 */
		Mydh mydh=new Mydh();
		parser.parse(new File("./src/contact.xml"), mydh);
		String string=mydh.getContent();
		System.out.println(string);
	}

}
