package com.gqx.work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuessServlet extends HttpServlet {

	/**
	 * 产生一个随机的数字（666），给5次机会让客户猜测这个数字
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String num=request.getParameter("number");
		Integer time=1;
		String times=request.getParameter("times");
		String value="";
		int key;
		System.out.println(times);
		if (times !=null  &&  !times.equals("")) {
				time=Integer.parseInt(times)+1;
		}
		if (num=="" || num==null) {
			value="请填入数字";
		}else {
			key=Integer.parseInt(num);
			if (key==666) {
				value="=";
			}else if (key>666) {
				value="大";
			}else {
				value="小";
			}
			request.setAttribute("answer", value);
		}

		if (time>4) {
			response.getWriter().write("游戏结束，<a href='"+request.getContextPath()+"/work1/guess.jsp'>再来一局</a>");
			return;
		}
		request.setAttribute("times", time);
		request.getRequestDispatcher("work1/guess.jsp").forward(request, response);
	

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
