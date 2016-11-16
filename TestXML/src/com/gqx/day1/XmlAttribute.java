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
	
	
	//获取属性(先获得属性所在的标签对象，然后才可以获取属性)
	//1、获得标签对象
	org.dom4j.Element conElement=document.getRootElement().element("contact");	
	//2、得到属性
	//2.1、得到指定名称的属性值
	String idString=conElement.attributeValue("id");
	System.out.println(idString);
	
	
	//2.2、得到指定名称属性对象
		org.dom4j.Attribute idAttribute=conElement.attribute("id");
		//getValue属性值
		System.out.println(idAttribute.getName()+":"+idAttribute.getValue());
		
		//2.3、得到所有属性的对象,返回list集合
		List<org.dom4j.Attribute> list=conElement.attributes();
		for (org.dom4j.Attribute attribute : list) {
			System.out.println(attribute.getName()+" : "+attribute.getValue());
		}
		
		//得到所有属性对象，返回迭代器对象
		Iterator<org.dom4j.Attribute> atttrIterator=conElement.attributeIterator();
		
		while (atttrIterator.hasNext()) {
			org.dom4j.Attribute attribute2 = atttrIterator.next();
			System.out.println(attribute2.getName()+" : "+attribute2.getValue());
		}
		
		
		//获取文本（先取得标签，在获取标签上的文本）
		//1、得到文本
		org.dom4j.Element conElement2=document.getRootElement().element("contact").element("name");
		String textString=conElement2.getText();
		System.out.println(textString);
		//得到指定纸标签的文本内容
		String textString2=document.getRootElement().element("contact").elementText("name");
		System.out.println(textString2);
	}
	
	

}
