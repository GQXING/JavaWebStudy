package com.gqx.test2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo2 extends HttpServlet {

	/**
	 * ����һ�������ض���
	 * �൱�ڳ�������תҳ��
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 *  ������ת����һ��ҳ��
		 *  ʹ���ض��򣬷���һ��302״̬��+location����Ӧͷ
		 */
//		response.setStatus(302);
//		response.setHeader("location", "/HttpTest/index.jsp");	//location����Ӧͷ
		
		//�����ض���ļ�д��
		response.sendRedirect( "/HttpTest/index.jsp");
	}
}
