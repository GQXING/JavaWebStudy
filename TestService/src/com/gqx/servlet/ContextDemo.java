package com.gqx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextDemo extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ��ǰwebӦ�û����µ�ServletContext����
		ServletContext context=this.getServletContext();
		String string=context.getInitParameter("driver");
		System.out.println("����driver��ֵΪ��"+string);
		System.err.println("--------------");
		//��ȡȫ���Ĳ�������ֵ
		Enumeration<String> enus=context.getInitParameterNames();
		while (enus.hasMoreElements()) {
			String str = (String) enus.nextElement();
			String value=context.getInitParameter(str);
			System.out.println(str+":"+value);
		}
		
		//���Եõ�configDemo�е�servlet����
		String path=this.getServletConfig().getInitParameter("user");
		System.out.println("path"+path);
		
	}
}
