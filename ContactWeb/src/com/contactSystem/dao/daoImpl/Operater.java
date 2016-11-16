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
	//�����ϵ��
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
		
		//��ʼ��Ӹ���
		Element element=rootElem.addElement("contact");
		//��ϵͳ�Զ�����һ�����Ψһ��ID��������ϵ��Id��ϵͳ�ṩ��һ����UUID��
		String uuid=UUID.randomUUID().toString().replace("-", "");
		
		element.addAttribute("Id", uuid);
		element.addElement("����").setText(contact.getName());
		element.addElement("name").setText(contact.getName());
		element.addElement("sex").setText(contact.getSex());
		element.addElement("age").setText(contact.getAge());
		element.addElement("phone").setText(contact.getPhone());
		element.addElement("email").setText(contact.getEmail());
		element.addElement("qq").setText(contact.getQq());
		
		//д�뵽���ص�xml�ĵ���
		XMLUtil.write2xml(doc);
		
	}

	@Override
	public void updateContact(Contact contact) throws Exception {
		// TODO Auto-generated method stub
		//ͨ��xpath���Ҷ�Ӧid����ϵ��
		Document document=XMLUtil.getDocument();
		Element element=(Element) document.selectSingleNode("//contact[@Id='"+contact.getId()+"']");
		//���ݱ�ǩ���ı�
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
		//ͨ��xpathȥ���Ҷ�Ӧ��contact
		Document document=XMLUtil.getDocument();
		Element element=(Element) document.selectSingleNode("//contact[@Id='"+id+"']");
		/**
		 * ����ǻ����������䱾����һ��bug������һ��get���������ظ������Σ�
		 * ��һ�λ��һ��Ψһ��id��ɾ�����������ڵڶ��ε�ʱ���������ȥɾ�������ʱ����Ҳ������ᱨ���ᷢ������
		 * Ϊ�˽�����bug��������������֤���Ƿ�Ϊ��
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
	 * true:˵���ظ�
	 * false��˵��û���ظ�
	 */
	@Override
	public boolean checkIfContact(String name) {
		// TODO Auto-generated method stub
		//��ѯname��ǩ�Ƿ�һ��
		Document doc=XMLUtil.getDocument();
		Element element=(Element) doc.selectSingleNode("//name[text()='"+name+"']");
		if (element!=null) {
			return true;
		}else {
			return false;
		}

	}

}
