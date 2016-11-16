package com.gqxing.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadDemo extends HttpServlet {
	
	/**
	 * 多线程安全问题
	 * 案例：访问网站的第几个人数
	 */
	int count=1;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("你现在是当前网站的第"+count+"个访客！");
		//为了效果，这里用sleep方法去让线程同步
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//当多个线程同时访问这里获取相同的count值的时候会发生线程安全问题。
		count++;
	}

}
