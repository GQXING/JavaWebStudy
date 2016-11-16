package com.gqx.test2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 通过response对象改变相应信息
		 */
			//1、响应行
			//response.setStatus(404);	//修改状态码
			//response.sendError(404);		//发送404状态码+404错误页面
		
		//2、改变响应头
		response.setHeader("server", "JBoss");
		
		//3、实体内容
		//	response.getWriter().write("1、hello world");	//字符内容
		response.getOutputStream().write("2、hello world".getBytes()); 	//字节内容
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
