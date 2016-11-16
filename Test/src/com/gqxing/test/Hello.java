package com.gqxing.test;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class Hello  implements Servlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
	
		System.out.println("destory......");
	}

	

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig.......");
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo......");
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init.................");
		ServletContext servletContext=arg0.getServletContext();
		String pathString=servletContext.getContextPath();
		System.out.println(pathString);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
	}
	
	public Hello(){
		System.out.println("我是构造方法！");
	}

}
