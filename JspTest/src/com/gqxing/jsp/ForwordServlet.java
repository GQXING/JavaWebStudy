package com.gqxing.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwordServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("ForwardServlet's daGet");
			request.setAttribute("name", "abc");
			System.out.println("ForwardServlet name"+request.getAttribute("name"));
			
			//�����ת��
			//1������httpservlet��getrequestdispatcher()�ķ�����ȡrequestDispatcher����
			//����getRequestDispatcher()��Ҫ����ת���ĵ�ַ
			String path="testServlet";
			RequestDispatcher dispatcher=request.getRequestDispatcher("/"+path);
			//2������httpservletRequest��forword��request,reqponse)���������ת��
			dispatcher.forward(request, response);
	}

}
