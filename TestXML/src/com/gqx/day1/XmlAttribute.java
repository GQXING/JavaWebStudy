package com.gqx.day1;

import java.io.File;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Iterator;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XmlAttribute {

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub

	SAXReader reader=new SAXReader();
	org.dom4j.Document document=reader.read(new File("./src/contact.xml"));
	
	
	//��ȡ����(�Ȼ���������ڵı�ǩ����Ȼ��ſ��Ի�ȡ����)
	//1����ñ�ǩ����
	org.dom4j.Element conElement=document.getRootElement().element("contact");	
	//2���õ�����
	//2.1���õ�ָ�����Ƶ�����ֵ
	String idString=conElement.attributeValue("id");
	System.out.println(idString);
	
	
	//2.2���õ�ָ���������Զ���
		org.dom4j.Attribute idAttribute=conElement.attribute("id");
		//getValue����ֵ
		System.out.println(idAttribute.getName()+":"+idAttribute.getValue());
		
		//2.3���õ��������ԵĶ���,����list����
		List<org.dom4j.Attribute> list=conElement.attributes();
		for (org.dom4j.Attribute attribute : list) {
			System.out.println(attribute.getName()+" : "+attribute.getValue());
		}
		
		//�õ��������Զ��󣬷��ص���������
		Iterator<org.dom4j.Attribute> atttrIterator=conElement.attributeIterator();
		
		while (atttrIterator.hasNext()) {
			org.dom4j.Attribute attribute2 = atttrIterator.next();
			System.out.println(attribute2.getName()+" : "+attribute2.getValue());
		}
		
		
		//��ȡ�ı�����ȡ�ñ�ǩ���ڻ�ȡ��ǩ�ϵ��ı���
		//1���õ��ı�
		org.dom4j.Element conElement2=document.getRootElement().element("contact").element("name");
		String textString=conElement2.getText();
		System.out.println(textString);
		//�õ�ָ��ֽ��ǩ���ı�����
		String textString2=document.getRootElement().element("contact").elementText("name");
		System.out.println(textString2);
	}
	
	

}
