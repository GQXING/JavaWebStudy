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
		 * ��servlet�����˳�ʼ��������web�����ڴ���servletʵ������ʱ��
		 * ���Զ�����Щ��ʼ��������װ��ServletConfig�����У����ڵ���servlet��init����ʱ��
		 * ��ServletConfig���󴫵ݸ�servlet��
		 * ����������Աͨ��ServletConfig����Ϳ��Եõ���ǰservlet�ĳ�ʼ��������Ϣ��
		 */
		// TODO Auto-generated method stub
		System.out.println("init");
		String user=arg0.getInitParameter("user");
		System.out.println("user:"+user);
		//��ȡ��������ɵ�enumeration����
		Enumeration<String> names=arg0.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name=names.nextElement();
			//��ȡָ���������ĳ�ʼ��ֵ
			String value=arg0.getInitParameter(name);
			System.out.println("^~^"+name+":"+value);
		}	
		//��ȡservlet����������
		String servletName=arg0.getServletName();
		System.out.println(servletName);	
		//��ȡservletContext����
		/*
		 *�ö������ǰwebӦ�ã�������ΪServletContext�ǵ�ǰwebӦ�õ�һ����ܼ�
		 *���Դ��л�ȡ����ǰweb�ĸ����������Ϣ
		 */
		ServletContext servletContext=arg0.getServletContext();
		String pathString=servletContext.getContextPath();
		System.out.println("��Ŀ·��"+pathString);
		
		 //�ٻ�ȡ��ǰwebӦ�õĳ�ʼ������
		String driverString=servletContext.getInitParameter("driver");
		System.out.println("-----------------driver:"+driverString);
		
		Enumeration<String> name2=servletContext.getInitParameterNames();
		while (name2.hasMoreElements()) {
			String nameString=name2.nextElement();
			String valueString=servletContext.getInitParameter(nameString);
			System.out.println("->"+nameString+":"+valueString);
		}
		
		//��ȡ��ǰwebӦ�õ�ĳһ���ļ��ľ���·�� F:\myeclipse-workplace\ServletTest\WebRoot\index.jsp
		String realPath=servletContext.getRealPath("/index.jsp");
		System.out.println("realPath"+realPath);
		//F:\myeclipse-workplace\.metadata\.me_tcat7\webapps\ServletTest\index.jsp
		//��ȡ��ǰwebӦ�õ�ĳһ�ļ��ڷ������ϵľ���·���������ǲ���ǰ��
		
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
