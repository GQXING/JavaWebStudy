package com.gqx.day1;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/*
 * ��xml�ļ���װ��������
 */
public class Fengzhuang {
	public static void  main(String[] args) throws DocumentException{
		List<Contact> contacts=new ArrayList<Contact>();
		//��ȡxml�ļ�
		SAXReader reader=new SAXReader();
		Document document=reader.read(new File("./src/contact.xml"));
		Element rootElement=document.getRootElement();
		//��ȡ��ǰ��ǩ�ڵ��µ������ӽڵ�	
		Iterator<Element> iterator=rootElement.elementIterator("contact");
		while (iterator.hasNext()) {
			Element element = (Element) iterator.next();
			Contact contact=new Contact();
			contact.setId(element.attributeValue("id"));
			contact.setName(element.elementText("name"));
			contact.setAge(element.elementText("age"));
			contact.setPhone(element.elementText("phone"));
			contact.setEmail(element.elementText("email"));
			contact.setQq(element.elementText("qq"));
			contacts.add(contact);
		}
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
}
