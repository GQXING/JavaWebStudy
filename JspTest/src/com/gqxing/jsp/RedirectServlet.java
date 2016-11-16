package com.gqxing.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet {


	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("RedirectServlet的doGet方法");
		
		
		request.setAttribute("name", "xyz");
		System.out.println("RedirectServlet name"+request.getAttribute("name"));
		
		
		//执行请求的重定向，直接调用response.sendRedirect(path)方法.
		String path="testServlet";
		response.sendRedirect(path);
	}

}
