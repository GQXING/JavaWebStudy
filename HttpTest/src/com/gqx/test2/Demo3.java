package com.gqx.test2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo3 extends HttpServlet {

	/**
	 * ����  ��ʱˢ��
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * ҳ�涨ʱˢ��
		 * ԭ���������ʶrefreshͷ���õ�refreshͷ������������Դ
		 */
		//response.setHeader("refresh", "1"); 	//ÿ��һ��ˢ�±�ҳ��
		/**
		 * ��n��֮��ת���������Դ
		 */
		response.setHeader("refresh", "3;url=/HttpTest/index.jsp");	//������֮������index.jspѹ��	
	}

}
