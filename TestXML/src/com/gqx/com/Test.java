package com.gqx.Test;

import java.util.List;

import org.junit.Before;

import com.gqx.homework.Contact;

public class Test {

Operator operator=null;
	
	//初始化这个对象的实例
	@Before
	public void init(){
		 operator=new Operator();
	}
	@org.junit.Test
	public void AddContact() throws Exception{
		Contact contact=new  Contact();
		contact.setId("002");
		contact.setAge("21");
		contact.setEmail("454444@qq.com");
		contact.setName("gqxing");
		contact.setPhone("13455555");
		contact.setQq("235346662");
		contact.setSex("男");
		
		operator.addContact(contact);
	}
	
	@org.junit.Test
	public void UpdateContact() throws Exception{
		Contact contact=new  Contact();
		contact.setId("003");
		contact.setAge("0");
		contact.setEmail("0000000@qq.com");
		contact.setName("test");
		contact.setPhone("0-00000000000");
		contact.setQq("000000000000");
		contact.setSex("男");
		
		operator.ModifyContact(contact);
	}
	
	@org.junit.Test
	public void  removeContact() throws Exception{
		operator.removeContact("003");
	}
	@org.junit.Test
	public void  allContact() throws Exception{
		List<Contact> contacts= operator.checkContacts();
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
}
