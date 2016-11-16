package com.gqx.day1;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;

public class XMLContact {

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		SAXReader reader=new SAXReader();
		Document document=reader.read(new File("./src/contact.xml"));
		@SuppressWarnings("unchecked")
		Element elem=document.getRootElement();
		StringBuffer stringBuffer=new StringBuffer();
		getElem(elem,stringBuffer);
		System.out.println(stringBuffer.toString());
	}
	
	//获取当前标签下的属性
	private static String getAttribute(Element element){
		List<Attribute> list2=element.attributes();
		String str="";
		if (!list2.isEmpty()){
			for (Attribute attribute : list2) {
				str+=" "+attribute.getName()+"=\""+attribute.getValue()+"\"";
			}
		}
		return str;	
	}
	
	//获取当前标签下的所有标签
	
	private static void getElement(Element element,StringBuffer str){
		str.append("<"+element.getName());
		str.append(getAttribute(element)+">");
		//得到标签
		
		List<Element > list =element.elements();
		
		for (Element element2 : list) {
			//str.append(element2.getText());
			getElement(element2, str);
		}	
		str.append("</"+element.getName()+">");
	}
	
	
	private static void getElem(Element element,StringBuffer str){
		str.append("<"+element.getName());
		str.append(getAttribute(element)+">");
		//得到标签
		//获取当前标签节点下的所有子节点
		Iterator< Node> iterator=element.nodeIterator();
		while (iterator.hasNext()) {
			Node node=iterator.next();	
			
			//标签
			if (node instanceof Element) {
				Element e=(Element)node;
				getElem(e, str);
			}
			
			//文本
			if (node instanceof Text) {
				Text text=(Text)node;
				str.append(text.getText());
			}
			
		}
		str.append("</"+element.getName()+">");
	}

}
