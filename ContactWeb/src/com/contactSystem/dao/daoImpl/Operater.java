package com.contactSystem.dao.daoImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.Tuple;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.contactSystem.dao.ContactOperate;
import com.contactSystem.entiey.Contact;
import com.contactSystem.util.XMLUtil;

public class Operater implements ContactOperate {

	@Override
	//添加联系人
	public void addContact(Contact contact) throws Exception {
		// TODO Auto-generated method stub
		File file=new File("e:/contact.xml");
		Document doc=null;
		Element rootElem=null;
		if (file.exists()) {
			doc=new SAXReader().read(file);
			rootElem=doc.getRootElement();
		}else {
			doc=DocumentHelper.createDocument();
			rootElem=doc.addElement("ContactList");
		}
		
		//开始添加个体
		Element element=rootElem.addElement("contact");
		//有系统自动生成一随机且唯一的ID，赋给联系人Id，系统提供了一个包UUID包
		String uuid=UUID.randomUUID().toString().replace("-", "");
		
		element.addAttribute("Id", uuid);
		element.addElement("姓名").setText(contact.getName());
		element.addElement("name").setText(contact.getName());
		element.addElement("sex").setText(contact.getSex());
		element.addElement("age").setText(contact.getAge());
		element.addElement("phone").setText(contact.getPhone());
		element.addElement("email").setText(contact.getEmail());
		element.addElement("qq").setText(contact.getQq());
		
		//写入到本地的xml文档中
		XMLUtil.write2xml(doc);
		
	}

	@Override
	public void updateContact(Contact contact) throws Exception {
		// TODO Auto-generated method stub
		//通过xpath查找对应id的联系人
		Document document=XMLUtil.getDocument();
		Element element=(Element) document.selectSingleNode("//contact[@Id='"+contact.getId()+"']");
		//根据标签改文本
		System.out.println(element);
		element.element("name").setText(contact.getName());
		element.element("age").setText(contact.getAge());
		element.element("email").setText(contact.getEmail());
		element.element("phone").setText(contact.getPhone());
		element.element("sex").setText(contact.getSex());
		element.element("qq").setText(contact.getQq());
		XMLUtil.write2xml(document);

	}

	@Override
	public void removeContact(String id) throws Exception {
		// TODO Auto-generated method stub
		//通过xpath去查找对应的contact
		Document document=XMLUtil.getDocument();
		Element element=(Element) document.selectSingleNode("//contact[@Id='"+id+"']");
		/**
		 * 如果是火狐浏览器，其本身有一个bug，对于一个get请求，它会重复做两次，
		 * 第一次会把一个唯一的id给删除掉，但是在第二次的时候，它会继续去删，而这个时候查找不到，会报错，会发生错误，
		 * 为了解决这个bug，我们在这里验证其是否为空
		 */
		if (element!=null) {
			element.detach();
			XMLUtil.write2xml(document);
		}
	}

	@Override
	public Contact findContact(String id) throws Exception {
		// TODO Auto-generated method stub
		Document document=XMLUtil.getDocument();
		Element e=(Element) document.selectSingleNode("//contact[@Id='"+id+"']");
		
		Contact contact=null;
		if (e!=null) {
			contact=new Contact();
			contact.setAge(e.elementText("age"));
			contact.setEmail(e.elementText("email"));
			contact.setId(id);
			contact.setName(e.elementText("name"));
			contact.setPhone(e.elementText("phone"));
			contact.setSex(e.elementText("sex"));
			contact.setQq(e.elementText("qq"));
		}
		return contact;
	}

	@Override
	public List<Contact> allContacts() {
		// TODO Auto-generated method stub
		Document document=XMLUtil.getDocument();
		List<Contact> list=new ArrayList<Contact>();
		List<Element> conElements=(List<Element>)document.selectNodes("//contact");
		for (Element element : conElements) {
			Contact contact=new Contact();
			contact.setId(element.attributeValue("Id"));
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
	/**
	 * true:说明重复
	 * false：说明没有重复
	 */
	@Override
	public boolean checkIfContact(String name) {
		// TODO Auto-generated method stub
		//查询name标签是否一样
		Document doc=XMLUtil.getDocument();
		Element element=(Element) doc.selectSingleNode("//name[text()='"+name+"']");
		if (element!=null) {
			return true;
		}else {
			return false;
		}

	}

}
