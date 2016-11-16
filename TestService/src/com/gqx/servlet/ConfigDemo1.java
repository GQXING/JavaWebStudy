package com.gqx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigDemo1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取当前web应用环境下的ServletContext对象
		ServletContext context=this.getServletContext();
		
		//得到web应用的路径,用在请求重定向的资源名称中
		String path=context.getContextPath();
		System.out.println(path);
		
		//请求重定向 (一般与上面的路径一起用,
		response.sendRedirect(path+"/index.html");
	}
}
