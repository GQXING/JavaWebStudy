package com.gqx.xmlwork;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class SXml {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String nameSpace = "xmln:xsi=http://www.w3.org/2001/XMLSchema-instance";
	
		File file=new File("e:/student.xml");
		Document doc=null;
		Element rootElem=null;
		if (file.exists()) {
			doc=new SAXReader().read(file);
			rootElem=doc.getRootElement();
		}else {
			//如果没有xml文件，创建xml文件
			doc=DocumentHelper.createDocument();
			rootElem=doc.addElement("Students");
		    rootElem.addAttribute("xmln:xsi","http://www.w3.org/2001/XMLSchema-instance");
		    rootElem.addAttribute("xsi:noNameSpaceSchemaLocation","Student.xsd");
		}
	
		Element stuElement=rootElem.addElement("Student");
		stuElement.addAttribute("Id", "001");
		stuElement.addAttribute("Class", "软工一班");
		stuElement.addElement("Name").setText("郭庆兴");
		stuElement.addElement("sex").setText("男");
		stuElement.addElement("City").setText("荆州");
		stuElement.addElement("Mobile").setText("13545642616");
		XMLUtil.write2xml(doc);
	}
}
