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
	 * 开始文档调用
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Mydh.startDocument()");
	}
	
	/*
	 * 开始标签时调用
	 * @param qName :开始标签的标签吗
	 * @param attributes 开始标签的属性
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
			buffer.append("<"+qName);
			//判断是否有属性
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
	 * 读到结束标签时调用
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		buffer.append("</"+qName+">");
	}
	
	/**
	 *读到文本时调用 
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//得到当前文本内容
		String content=new String(ch,start,length);
		buffer.append(content);
	}
	
	/**
	 * 结束文档时调用
	 * 
	 */
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Mydh.endDocument()");
	}
}
