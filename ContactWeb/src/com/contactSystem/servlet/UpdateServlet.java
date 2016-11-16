package com.contactSystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactSystem.dao.daoImpl.Operater;
import com.contactSystem.entiey.Contact;
import com.contactSystem.service.ContactService;
import com.contactSystem.service.imple.ContactServiceImpe;

public class UpdateServlet extends HttpServlet {

	/**
	 * 将修改后的数据提交
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("userName");
		String age=request.getParameter("age");
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String qq=request.getParameter("qq");
		String email=request.getParameter("email");
		String id=request.getParameter("id");
		ContactService service=new ContactServiceImpe();
		Contact contact=new Contact();
		contact.setId(id);
		contact.setName(userName);
		contact.setAge(age);
		contact.setSex(sex);
		contact.setPhone(phone);
		contact.setQq(qq);
		contact.setEmail(email);
		try {
			service.updateContact(contact);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/Index");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
