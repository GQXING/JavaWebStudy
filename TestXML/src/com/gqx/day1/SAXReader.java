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
		//1������һ��xml��������
		org.dom4j.io.SAXReader reader=new org.dom4j.io.SAXReader();
		try {
			Document document=reader.read(new File("./src/contact.xml"));
			//nodeIterator():�õ���ǰ�ڵ��µ������ӽڵ���󣨲����������µĽڵ㣩
	
			Iterator<Node> it=document.nodeIterator();
			while (it.hasNext()) {//�ж��Ƿ�����һ��Ԫ��
				Node node=it.next();	//ȡ��Ԫ��
				String nameString=node.getName();	//�õ��ڵ�����
				System.out.println(nameString);
				
				//����ȡ����������ӽڵ�
				//ֻ�б�ǩ�ڵ�����ӽڵ�
				if (node instanceof Element){
					Element element=(Element)node;
					Iterator<Node> it2=element.nodeIterator();
					while (it2.hasNext()) {
						Node node2 =  it2.next();
						System.out.println(node2.getName());
					}
				}
			}	
			//�õ�����ǩ
			Element rootElement=document.getRootElement();			
			getChildNodes(rootElement);	
			//�õ���ǩ����
			String name=rootElement.getName();
			System.out.println(name);
			//�õ���ǰ��ǩ��ָ�����Ƶĵ�һ���ӱ�ǩ
			Element contactElement=rootElement.element("contact");
			System.out.println(contactElement.getName());	
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}	
	/*
	 * ��ȡ����ı�ǩ�µ������ӽڵ�
	 */
	private static void getChildNodes(Element element){
		System.out.println(element.getName());
		//�õ��ӽڵ�
		Iterator<Node> it=element.nodeIterator();
		while (it.hasNext()) {
			Node node = (Node) it.next();
			//1���ж��ǲ��Ǳ�ǩ�ӽڵ�
			if (node instanceof Element) {
				Element elem=(Element)node;
				getChildNodes(elem);
			}
		}
	}
}
