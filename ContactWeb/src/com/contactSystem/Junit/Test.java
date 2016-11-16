package com.contactSystem.Junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;

import com.contactSystem.dao.daoImpl.Operater;
import com.contactSystem.entiey.Contact;


public class Test {
Operater operator=null;
	
	//初始化这个对象的实例
	@Before
	public void init(){
		 operator=new Operater();
	}
	
	@org.junit.Test
	public void Add() throws Exception{
		Contact contact=new  Contact();

		contact.setAge("21");
		contact.setEmail("454444@qq.com");
		contact.setName("gqxing");
		contact.setPhone("13455555");
		contact.setQq("235346662");
		contact.setSex("男");
		operator.addContact(contact);
	}
	
	@org.junit.Test
	public void update() throws Exception{
		Contact contact=new  Contact();
		contact.setId("002");
		contact.setAge("0");
		contact.setEmail("0000000@qq.com");
		contact.setName("test");
		contact.setPhone("0-00000000000");
		contact.setQq("000000000000");
		contact.setSex("男");
		operator.updateContact(contact);
	}
	
	
	@org.junit.Test
	public void removeContact() throws Exception{
		operator.removeContact("002");
	}
	
	@org.junit.Test
	public void findContact() throws Exception{
		Contact contact=operator.findContact("002");
		System.out.println(contact);
	}
	
	@org.junit.Test
	public void allContact() throws Exception{
		List<Contact> contacts= operator.allContacts();
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
	@org.junit.Test
	public void TetsCheckBoolean() throws Exception{
		Boolean flag=operator.checkIfContact("郭庆兴");
		System.out.println(flag);
	}
	
	
}
