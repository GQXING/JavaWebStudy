package com.contactSystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactSystem.dao.daoImpl.Operater;
import com.contactSystem.entiey.Contact;
import com.contactSystem.exception.NameRepeatException;
import com.contactSystem.service.ContactService;
import com.contactSystem.service.imple.ContactServiceImpe;

public class addServlet extends HttpServlet {

	/**
	 * 处理添加联系人的逻辑
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("userName");
		String age=request.getParameter("age");
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String qq=request.getParameter("qq");
		String email=request.getParameter("email");
		
		ContactService service=new ContactServiceImpe();

		Contact contact=new Contact();
		contact.setName(userName);
		contact.setAge(age);
		contact.setSex(sex);
		contact.setPhone(phone);
		contact.setQq(qq);
		contact.setEmail(email);
		try {
			service.addContact(contact);
		} catch (NameRepeatException e) {
			// TODO Auto-generated catch block
			//处理名字重复的异常
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			return;
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
