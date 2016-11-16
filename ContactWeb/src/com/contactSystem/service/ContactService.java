package com.contactSystem.service;

import java.util.List;

import com.contactSystem.entiey.Contact;

public interface ContactService {
	public void addContact(Contact contact) throws Exception;
	public void updateContact(Contact contact) throws Exception;
	public void removeContact(String id) throws Exception;
	public Contact findContact(String id) throws Exception;
	public List<Contact>  allContacts();
}
