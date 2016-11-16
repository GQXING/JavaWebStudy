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

public class FindIdServlet extends HttpServlet {

	/**
	 * 修改联系人逻辑
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		ContactService service=new ContactServiceImpe();
		
		String id=request.getParameter("id");
		
		Contact contact=null;
		try {
			contact=service.findContact(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
