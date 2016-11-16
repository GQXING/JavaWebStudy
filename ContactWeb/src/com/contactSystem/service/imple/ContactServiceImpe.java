package com.contactSystem.service.imple;

import java.util.List;

import com.contactSystem.dao.daoImpl.Operater;
import com.contactSystem.entiey.Contact;
import com.contactSystem.exception.NameRepeatException;
import com.contactSystem.service.ContactService;
/**
 * ������Ŀ�г��ֵ�ҵ���߼�
 * @author Administrator
 *
 */
public class ContactServiceImpe implements ContactService {
	Operater operater =new Operater();
	@Override
	public void addContact(Contact contact) throws Exception {
		// TODO Auto-generated method stub
		//ִ��ҵ���߼��ж�
		/**
		 * ����Ƿ��ظ���ҵ���߼�
		 */
		if (operater.checkIfContact(contact.getName())) {
			//�ظ�
			/**
			 * ע�⣺���ҵ��㷽�������κδ����򷵻ر�ǣ��Զ�����쳣����servlet
			 */
			 throw new NameRepeatException("�����ظ�������ʹ��");
		}
		operater.addContact(contact);

	}

	@Override
	public void updateContact(Contact contact) throws Exception {
		// TODO Auto-generated method stub
		operater.updateContact(contact);
	}

	@Override
	public void removeContact(String id) throws Exception {
		// TODO Auto-generated method stub
		operater.removeContact(id);
	}

	@Override
	public Contact findContact(String id) throws Exception {
		// TODO Auto-generated method stub
		return operater.findContact(id);
	}

	@Override
	public List<Contact> allContacts() {
		// TODO Auto-generated method stub
		return operater.allContacts();
	}

}
