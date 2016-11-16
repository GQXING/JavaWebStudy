package com.gqx.SAXParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Mydh extends DefaultHandler {
	
	private StringBuffer buffer=new StringBuffer();
	
	public String getContent(){
		return buffer.toString();
	}
	/*
	 * ��ʼ�ĵ�����
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Mydh.startDocument()");
	}
	
	/*
	 * ��ʼ��ǩʱ����
	 * @param qName :��ʼ��ǩ�ı�ǩ��
	 * @param attributes ��ʼ��ǩ������
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
			buffer.append("<"+qName);
			//�ж��Ƿ�������
			if (attributes !=null) {
				for (int i = 0; i < attributes.getLength(); i++) {
					String name=attributes.getQName(i);
					String value=attributes.getValue(i);
					buffer.append(" "+name+"=\""+value+"\"");
				}
			}
			
			buffer.append(">");
	}
	
	/**
	 * ����������ǩʱ����
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		buffer.append("</"+qName+">");
	}
	
	/**
	 *�����ı�ʱ���� 
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//�õ���ǰ�ı�����
		String content=new String(ch,start,length);
		buffer.append(content);
	}
	
	/**
	 * �����ĵ�ʱ����
	 * 
	 */
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Mydh.endDocument()");
	}
}
