package com.gqx.SAXParser;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDH2 extends DefaultHandler {
	List<Contact> contacts=new ArrayList<Contact>();
	protected List<Contact> getContacts(){
		return contacts;
	}
	 private Contact contact;
	 
	 private String currentTag;
	 
	 /*
		 * 开始文档调用
		 */
		@Override
		public void startDocument() throws SAXException {
			// TODO Auto-generated method stub
			System.out.println("Mydh.startDocument()-->");
		}
		
		/*
		 * 开始标签时调用
		 * @param qName :开始标签的标签吗
		 * @param attributes 开始标签的属性
		 */
	 @Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		 if ("contact".equals(qName)) {
			contact=new Contact();
			//得到属性
			String value=attributes.getValue(0);
			contact.setId(value);
		} 
		 currentTag=qName;
	}
	 
	 /**
		 *读到文本时调用 
		 */
	 @Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String content=new String(ch,start,length);
		if ("name".equals(currentTag)) {
			contact.setName(content);
		}
		if ("age".equals(currentTag)) {
			contact.setAge(content);
		}
		if ("phone".equals(currentTag)) {
			contact.setPhone(content);
		}
		if ("email".equals(currentTag)) {
			contact.setEmail(content);
		}
		if ("qq".equals(currentTag)) {
			contact.setQq(content);
		}
	}
	 
	 /**
		 * 读到结束标签时调用
		 */
	 @Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		 currentTag=null;
		if ("contact".equals(qName)) {
			contacts.add(contact);
		}
	}
	 
	 /**
		 * 结束文档时调用
		 * 
		 */
		@Override
		public void endDocument() throws SAXException {
			System.out.println("Mydh.endDocument()-->");
		}
	 
}
