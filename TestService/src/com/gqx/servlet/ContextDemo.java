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
		//获取当前web应用环境下的ServletContext对象
		ServletContext context=this.getServletContext();
		String string=context.getInitParameter("driver");
		System.out.println("参数driver的值为："+string);
		System.err.println("--------------");
		//获取全部的参数及其值
		Enumeration<String> enus=context.getInitParameterNames();
		while (enus.hasMoreElements()) {
			String str = (String) enus.nextElement();
			String value=context.getInitParameter(str);
			System.out.println(str+":"+value);
		}
		
		//尝试得到configDemo中的servlet参数
		String path=this.getServletConfig().getInitParameter("user");
		System.out.println("path"+path);
		
	}
}
