package com.gqx.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.DocumentException;

import com.gqx.homework.Contact;

public interface ContactOperate {
	public void addContact(Contact contact) throws Exception;
	public void ModifyContact(Contact contact) throws Exception;
	public void removeContact(String id) throws Exception;
	public List<Contact>  checkContacts();
}
