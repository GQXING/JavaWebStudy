package com.gqx.xmlwork;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.management.RuntimeErrorException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/*
 * xml�����Ĺ�����
 */
public class XMLUtil {
	//д��һ��xml�ļ�
	public static void write2xml(Document doc) throws Exception{
		OutputStream out=new FileOutputStream("e:/student.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer=new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}
	
	//��ȡ����xml�ļ��ķ���
	public static Document getDocument(){
		Document doc;
		try {
			doc = new SAXReader().read("e:/student.xml");
			return doc;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
}
