package com.gqx.SessionDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	/**
	 * 处理登录的逻辑
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("userName");
		String password=request.getParameter("password");

		if (name.equals("gqxing") && password.equals("123456")) {
			//登入成功
			/*
			 *  context域对象：不合适，可能会覆盖数据。
			 *  首先假设用上request域对象，来实现页面的跳转页面数据的共享
			 */
			
			
			//				request.setAttribute("userName", name);		//添加保存共享的数据															
			//				 request.getRequestDispatcher("/IndexServlet").forward(request, response);  //请求的转发

			HttpSession session=request.getSession();
			session.setAttribute("userName", name);
			//这个时候可以用到重定向技术
			System.out.println("验证成功");
			response.sendRedirect(request.getContextPath()+"/IndexServlet");

		}else {
			//登入失败，重定向跳回原页面
			response.sendRedirect(request.getContextPath()+"/fail.html");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
