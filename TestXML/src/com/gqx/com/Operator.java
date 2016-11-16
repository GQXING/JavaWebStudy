package com.gqx.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.gqx.homework.Contact;



public class Operator implements ContactOperate {

	@Override
	public void addContact(Contact contact) throws Exception {
		// TODO Auto-generated method stub
		/**
		 * �����ϵ�ˣ���contact���浽xml�ĵ���
		 */
		File file=new File("e:/contact.xml");
		Document doc=null;
		Element rootElem=null;
		if (file.exists()) {
			doc=new SAXReader().read(file);
			rootElem=doc.getRootElement();
		}else {
			//���û��xml�ļ�������xml�ļ�
			doc=DocumentHelper.createDocument();
			rootElem=doc.addElement("contactList");
		}
	
		//���contact��ǩ
		Element contactElem=rootElem.addElement("contact");
		contactElem.addAttribute("id", contact.getId());
		contactElem.addElement("name").setText(contact.getName());
		contactElem.addElement("sex").setText(contact.getSex());
		contactElem.addElement("age").setText(contact.getAge());
		contactElem.addElement("phone").setText(contact.getPhone());
		contactElem.addElement("email").setText(contact.getEmail());
		contactElem.addElement("qq").setText(contact.getQq());
		/**
		 * �����жദ�õ���document����д��xml�ĵ��У�
		 * ��ʱ���Լ�ǿ����ĸ����ԣ�дһ��xml�Ĺ����࣬
		 * ����һ���������ǽ�documentת��Ϊxml�ľ�̬����
		 */
		XMLUtil.write2xml(doc);
	}

	@Override
	public void ModifyContact(Contact contact) throws Exception {
		// TODO Auto-generated method stub
		//����xpath�����ҵ�������idΪxx��contact
		//�ȶ�ȡxml�ļ�
		Document doc=new SAXReader().read("e:/contact.xml");
		//����xpath�����ҵ��ýڵ�
		Element contactNode=(Element) doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
		//���ݱ�ǩ���ı�
		contactNode.element("name").setText(contact.getName());
		contactNode.element("age").setText(contact.getAge());
		contactNode.element("email").setText(contact.getEmail());
		contactNode.element("phone").setText(contact.getPhone());
		contactNode.element("sex").setText(contact.getSex());
		XMLUtil.write2xml(doc);
	}

	@Override
	public void removeContact(String id) throws Exception {
		// TODO Auto-generated method stub
		//�ȶ�ȡxml�ļ�
		Document doc=XMLUtil.getDocument();
		//����xpath�����ҵ��ýڵ�
		Element contactNode=(Element) doc.selectSingleNode("//contact[@id='"+id+"']");
		//ɾ���ڵ�
		contactNode.detach();
		XMLUtil.write2xml(doc);
	}

	@Override
	public List<Contact> checkContacts() {
		// TODO Auto-generated method stub
		Document doc=XMLUtil.getDocument();
		//����list����
		List<Contact> list = new ArrayList<Contact>();
		List<Element> conList=(List<Element>) doc.selectNodes("//contact");
		for (Element element : conList) {
			Contact contact=new Contact();
			contact.setId(element.attributeValue("id"));
			contact.setAge(element.elementText("age"));
			contact.setEmail(element.elementText("email"));
			contact.setName(element.elementText("name"));
			contact.setPhone(element.elementText("phone"));
			contact.setQq(element.elementText("qq"));
			contact.setSex(element.elementText("sex"));
			list.add(contact);
		}
		return list;
	}

	


}
