package com.gqxing.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwordServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("ForwardServlet's daGet");
			request.setAttribute("name", "abc");
			System.out.println("ForwardServlet name"+request.getAttribute("name"));
			
			//请求的转发
			//1、调用httpservlet的getrequestdispatcher()的方法获取requestDispatcher对象。
			//调用getRequestDispatcher()需要传入转发的地址
			String path="testServlet";
			RequestDispatcher dispatcher=request.getRequestDispatcher("/"+path);
			//2、调用httpservletRequest的forword（request,reqponse)进行请求的转发
			dispatcher.forward(request, response);
	}

}
