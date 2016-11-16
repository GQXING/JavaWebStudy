package com.contactSystem.dao;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.DocumentException;
import com.contactSystem.entiey.Contact;

public interface ContactOperate {
	public void addContact(Contact contact) throws Exception;
	public void updateContact(Contact contact) throws Exception;
	public void removeContact(String id) throws Exception;
	public Contact findContact(String id) throws Exception;
	public List<Contact>  allContacts();
	//根据名称姓名查询是否有存在重复。
	public boolean checkIfContact(String name);
}
