package com.gqx.ModifyXML;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import com.gqx.day1.SAXReader;

public class Work {
	@Test
	public  void test()throws Exception{
		// TODO Auto-generated method stub
		Document document=new org.dom4j.io.SAXReader().read(new File("./src/c.xml"));
		Element rootElement=document.getRootElement();
		Element student1=rootElement.addElement("student33");
		student1.addAttribute("id", "1");
		student1.addElement("name").setText("����");
		student1.addElement("gender").setText("��");
		student1.addElement("grade").setText("�����һ��");
		student1.addElement("address").setText("�������");	
		Element student2=rootElement.addElement("student");
		student2.addAttribute("id", "2");
		student2.addElement("name").setText("����");
		student2.addElement("gender").setText("��");
		student2.addElement("grade").setText("�����һ��");
		student2.addElement("address").setText("�������");	
		FileOutputStream out=new FileOutputStream("./src/c.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer=new XMLWriter(out,format);
		writer.write(document);
		writer.close();
	}
	/*
	 * ɾ��idΪ2
	 * ��ѧ��
	 */
	@Test
	public void test2()throws Exception{
		Document document=new org.dom4j.io.SAXReader().read(new File("e:/student.xml"));
		Iterator<Element> iterator=document.getRootElement().elementIterator("student");
		while (iterator.hasNext()) {
			Element element = iterator.next();
			if (element.attribute("id").getText().equals("2")) {
				System.out.println("k");
				element.detach();
			}
		}
		
		//3.1 ���λ��
		FileOutputStream out = new FileOutputStream("e:/student.xml");
		//3.2 ָ����ʽ
		OutputFormat format = OutputFormat.createPrettyPrint();
		// ���ñ���
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		//3.3 д������
		writer.write(document);
		//3.4�ر���Դ
		writer.close();
	}
}
