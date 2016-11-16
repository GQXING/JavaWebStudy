package com.gqxing.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Hello implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory.......");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("ServletConfig.......");
		return null;
	}
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo");
		return null;
	}
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		/*
		 * 当servlet配置了初始化参数后，web容器在创建servlet实例对象时，
		 * 会自动将这些初始化参数封装到ServletConfig对象中，并在调用servlet的init方法时，
		 * 将ServletConfig对象传递给servlet。
		 * 进而，程序员通过ServletConfig对象就可以得到当前servlet的初始化参数信息。
		 */
		// TODO Auto-generated method stub
		System.out.println("init");
		String user=arg0.getInitParameter("user");
		System.out.println("user:"+user);
		//获取参数名组成的enumeration对象
		Enumeration<String> names=arg0.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name=names.nextElement();
			//获取指定参数名的初始化值
			String value=arg0.getInitParameter(name);
			System.out.println("^~^"+name+":"+value);
		}	
		//获取servlet的配置名称
		String servletName=arg0.getServletName();
		System.out.println(servletName);	
		//获取servletContext对象
		/*
		 *该对象代表当前web应用：可以认为ServletContext是当前web应用的一个大管家
		 *可以从中获取到当前web的各个方面的信息
		 */
		ServletContext servletContext=arg0.getServletContext();
		String pathString=servletContext.getContextPath();
		System.out.println("项目路径"+pathString);
		
		 //①获取当前web应用的初始化参数
		String driverString=servletContext.getInitParameter("driver");
		System.out.println("-----------------driver:"+driverString);
		
		Enumeration<String> name2=servletContext.getInitParameterNames();
		while (name2.hasMoreElements()) {
			String nameString=name2.nextElement();
			String valueString=servletContext.getInitParameter(nameString);
			System.out.println("->"+nameString+":"+valueString);
		}
		
		//获取当前web应用的某一个文件的绝对路径 F:\myeclipse-workplace\ServletTest\WebRoot\index.jsp
		String realPath=servletContext.getRealPath("/index.jsp");
		System.out.println("realPath"+realPath);
		//F:\myeclipse-workplace\.metadata\.me_tcat7\webapps\ServletTest\index.jsp
		//获取当前web应用的某一文件在服务器上的绝对路径，而不是部署前的
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
	}
	public Hello(){
		System.out.println("Hello ,Servlet!");
	}
}
