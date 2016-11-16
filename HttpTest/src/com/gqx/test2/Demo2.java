package com.gqx.test2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo2 extends HttpServlet {

	/**
	 * 案例一：请求重定向
	 * 相当于超链接跳转页面
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 *  需求：跳转到另一个页面
		 *  使用重定向，发送一个302状态码+location的响应头
		 */
//		response.setStatus(302);
//		response.setHeader("location", "/HttpTest/index.jsp");	//location是响应头
		
		//请求重定向的简化写法
		response.sendRedirect( "/HttpTest/index.jsp");
	}
}
