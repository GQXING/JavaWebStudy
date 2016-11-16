package com.gqx.day1;

import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.util.Iterator;

import org.dom4j.*;
import org.junit.Test;

public class SAXReader {
	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1、创建一个xml解析对象
		org.dom4j.io.SAXReader reader=new org.dom4j.io.SAXReader();
		try {
			Document document=reader.read(new File("./src/contact.xml"));
			//nodeIterator():得到当前节点下的所有子节点对象（不包括孙以下的节点）
	
			Iterator<Node> it=document.nodeIterator();
			while (it.hasNext()) {//判断是否有下一个元素
				Node node=it.next();	//取出元素
				String nameString=node.getName();	//得道节点名称
				System.out.println(nameString);
				
				//继续取出其下面的子节点
				//只有标签节点才有子节点
				if (node instanceof Element){
					Element element=(Element)node;
					Iterator<Node> it2=element.nodeIterator();
					while (it2.hasNext()) {
						Node node2 =  it2.next();
						System.out.println(node2.getName());
					}
				}
			}	
			//得到根标签
			Element rootElement=document.getRootElement();			
			getChildNodes(rootElement);	
			//得到标签名称
			String name=rootElement.getName();
			System.out.println(name);
			//得到当前标签下指定名称的第一个子标签
			Element contactElement=rootElement.element("contact");
			System.out.println(contactElement.getName());	
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}	
	/*
	 * 获取传入的标签下的所有子节点
	 */
	private static void getChildNodes(Element element){
		System.out.println(element.getName());
		//得到子节点
		Iterator<Node> it=element.nodeIterator();
		while (it.hasNext()) {
			Node node = (Node) it.next();
			//1、判断是不是标签子节点
			if (node instanceof Element) {
				Element elem=(Element)node;
				getChildNodes(elem);
			}
		}
	}
}
