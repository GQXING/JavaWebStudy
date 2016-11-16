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
		 * ��ʼ�ĵ�����
		 */
		@Override
		public void startDocument() throws SAXException {
			// TODO Auto-generated method stub
			System.out.println("Mydh.startDocument()-->");
		}
		
		/*
		 * ��ʼ��ǩʱ����
		 * @param qName :��ʼ��ǩ�ı�ǩ��
		 * @param attributes ��ʼ��ǩ������
		 */
	 @Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		 if ("contact".equals(qName)) {
			contact=new Contact();
			//�õ�����
			String value=attributes.getValue(0);
			contact.setId(value);
		} 
		 currentTag=qName;
	}
	 
	 /**
		 *�����ı�ʱ���� 
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
		 * ����������ǩʱ����
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
		 * �����ĵ�ʱ����
		 * 
		 */
		@Override
		public void endDocument() throws SAXException {
			System.out.println("Mydh.endDocument()-->");
		}
	 
}
