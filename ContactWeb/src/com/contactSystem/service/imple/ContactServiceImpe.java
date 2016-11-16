package com.contactSystem.service.imple;

import java.util.List;

import com.contactSystem.dao.daoImpl.Operater;
import com.contactSystem.entiey.Contact;
import com.contactSystem.exception.NameRepeatException;
import com.contactSystem.service.ContactService;
/**
 * 处理项目中出现的业务逻辑
 * @author Administrator
 *
 */
public class ContactServiceImpe implements ContactService {
	Operater operater =new Operater();
	@Override
	public void addContact(Contact contact) throws Exception {
		// TODO Auto-generated method stub
		//执行业务逻辑判断
		/**
		 * 添加是否重复的业务逻辑
		 */
		if (operater.checkIfContact(contact.getName())) {
			//重复
			/**
			 * 注意：如果业务层方法出现任何错误，则返回标记（自定义的异常）到servlet
			 */
			 throw new NameRepeatException("姓名重复，不可使用");
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
