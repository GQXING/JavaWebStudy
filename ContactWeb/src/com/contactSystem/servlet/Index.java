package com.contactSystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactSystem.dao.daoImpl.Operater;
import com.contactSystem.entiey.Contact;
import com.contactSystem.service.ContactService;
import com.contactSystem.service.imple.ContactServiceImpe;

public class Index extends HttpServlet {

	/**
	 * 显示所有联系人的逻辑方式
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		ContactService service=new ContactServiceImpe();
		List<Contact> contacts=service.allContacts();

		
		/**
		 * shift+alt+A ——>区域选择 
		 * 正则表达式：“."表示任意字符，"*"表示多个字符
		 *             “/1”表示一行代表匹配一行内容
		 */
		
		request.setAttribute("contacts", contacts);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
