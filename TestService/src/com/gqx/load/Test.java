package com.gqx.load;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {
	/**
	 * ����������ʹ�õģ� /��ʾ��ǰweb�ĸ�Ŀ¼ (webroot��)
	 * ���������ʹ�õģ�/��ʾ��webapps�ĸ�Ŀ¼(webapps��)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		/**
		 * ת��
		 */
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		/**
		 * ������ض���
		 */
//		response.sendRedirect("/TestService/index.jsp");
		
		/**
		 * html������
		 */
		response.getWriter().write("<html><body><a href='/TestService/index.jsp'>������</a></body><html>");
		
		/**
		 * htmlҳ���б����ύ
		 */
		response.getWriter().write("<html><body><form action='/TestService/index.jsp'><input type='submit'/></form></body><html>");
		
	}
}
