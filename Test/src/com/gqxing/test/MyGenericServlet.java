package com.gqxing.test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * �Զ����һ��servlet��ڵ�ʵ����,�ÿ������κ�Servlet���̳��Ը����Լ򻯿�����
 */
public abstract  class MyGenericServlet implements Servlet,ServletConfig {

	@Override
	public void destroy() {}
			
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.servletConfig;
	}
	private ServletConfig servletConfig;
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.servletConfig=arg0;
	}

	@Override
	public abstract void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException;

	
	
	
	
	/*
	 * һ�·�������ΪServletConfig�ļӿ۷���
	 */
	@Override
	public String getInitParameter(String arg0) {
		// TODO Auto-generated method stub
		return servletConfig.getInitParameter(arg0);
	}

	@Override
	public Enumeration getInitParameterNames() {
		// TODO Auto-generated method stub
		return servletConfig.getInitParameterNames();
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return servletConfig.getServletContext();
	}

	@Override
	public String getServletName() {
		// TODO Auto-generated method stub
		return servletConfig.getServletName();
	}

}
