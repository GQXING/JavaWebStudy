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
		 * 添加联系人，把contact保存到xml文档中
		 */
		File file=new File("e:/contact.xml");
		Document doc=null;
		Element rootElem=null;
		if (file.exists()) {
			doc=new SAXReader().read(file);
			rootElem=doc.getRootElement();
		}else {
			//如果没有xml文件，创建xml文件
			doc=DocumentHelper.createDocument();
			rootElem=doc.addElement("contactList");
		}
	
		//添加contact标签
		Element contactElem=rootElem.addElement("contact");
		contactElem.addAttribute("id", contact.getId());
		contactElem.addElement("name").setText(contact.getName());
		contactElem.addElement("sex").setText(contact.getSex());
		contactElem.addElement("age").setText(contact.getAge());
		contactElem.addElement("phone").setText(contact.getPhone());
		contactElem.addElement("email").setText(contact.getEmail());
		contactElem.addElement("qq").setText(contact.getQq());
		/**
		 * 代码中多处用到将document对象写入xml文档中，
		 * 此时可以加强代码的复用性，写一个xml的工具类，
		 * 其中一个方法便是将document转化为xml的静态方法
		 */
		XMLUtil.write2xml(doc);
	}

	@Override
	public void ModifyContact(Contact contact) throws Exception {
		// TODO Auto-generated method stub
		//根据xpath快速找到其属性id为xx的contact
		//先读取xml文件
		Document doc=new SAXReader().read("e:/contact.xml");
		//根据xpath快熟找到该节点
		Element contactNode=(Element) doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
		//根据标签该文本
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
		//先读取xml文件
		Document doc=XMLUtil.getDocument();
		//根据xpath快熟找到该节点
		Element contactNode=(Element) doc.selectSingleNode("//contact[@id='"+id+"']");
		//删除节点
		contactNode.detach();
		XMLUtil.write2xml(doc);
	}

	@Override
	public List<Contact> checkContacts() {
		// TODO Auto-generated method stub
		Document doc=XMLUtil.getDocument();
		//创建list集合
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
