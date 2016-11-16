package com.gqx.test2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo3 extends HttpServlet {

	/**
	 * 案例  定时刷新
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 页面定时刷新
		 * 原理：浏览器认识refresh头，得到refresh头后重新申请资源
		 */
		//response.setHeader("refresh", "1"); 	//每隔一秒刷新本页面
		/**
		 * 隔n秒之后转到另外的资源
		 */
		response.setHeader("refresh", "3;url=/HttpTest/index.jsp");	//隔三秒之后跳到index.jsp压面	
	}

}
