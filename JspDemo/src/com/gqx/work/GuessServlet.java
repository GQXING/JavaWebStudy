package com.gqx.work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuessServlet extends HttpServlet {

	/**
	 * ����һ����������֣�666������5�λ����ÿͻ��²��������
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
			value="����������";
		}else {
			key=Integer.parseInt(num);
			if (key==666) {
				value="=";
			}else if (key>666) {
				value="��";
			}else {
				value="С";
			}
			request.setAttribute("answer", value);
		}

		if (time>4) {
			response.getWriter().write("��Ϸ������<a href='"+request.getContextPath()+"/work1/guess.jsp'>����һ��</a>");
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
