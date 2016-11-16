package com.gqx.day1;

import java.awt.List;
import java.io.File;

import javax.lang.model.element.Element;
import javax.swing.text.Document;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class SAXReader2 {

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		SAXReader reader=new SAXReader();
		org.dom4j.Document document=reader.read(new File("./src/contact.xml"));
		//�õ�����ǩ
		org.dom4j.Element rootElement=document.getRootElement();	
		String name=rootElement.getName();
		System.out.println(name);
		//�õ���ǰ��ǩ�µ������ӱ�ǩ
		java.util.List list=rootElement.elements();
		for (int i=0;i<list.size();i++) {			org.dom4j.Element e= (org.dom4j.Element) list.get(i);
			System.out.println(e.getName());
		}
		
		org.dom4j.Element nameElement=document.getRootElement().element("contact").element("name");
		System.out.println(nameElement.getName());
		
	}

}
