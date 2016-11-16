package com.gqxing.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadDemo2 extends HttpServlet {
	
	/**
	 * 多线程安全问题
	 * 案例：访问网站的第几个人数
	 */
	int count=1;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//为当前访问的线程加锁,
		synchronized (ThreadDemo2.class) {//锁线程必须是唯一的，可以用当前的字节码对象
			response.getWriter().write("你现在是当前网站的第"+count+"个访客！");
		}	
		count++;
	}

}
