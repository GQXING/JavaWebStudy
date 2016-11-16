package com.gqx.load;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {
	/**
	 * 给服务器端使用的： /表示当前web的根目录 (webroot下)
	 * 给浏览器端使用的：/表示在webapps的根目录(webapps下)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		/**
		 * 转发
		 */
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		/**
		 * 请求的重定向
		 */
//		response.sendRedirect("/TestService/index.jsp");
		
		/**
		 * html超链接
		 */
		response.getWriter().write("<html><body><a href='/TestService/index.jsp'>超连接</a></body><html>");
		
		/**
		 * html页面中表单的提交
		 */
		response.getWriter().write("<html><body><form action='/TestService/index.jsp'><input type='submit'/></form></body><html>");
		
	}
}
