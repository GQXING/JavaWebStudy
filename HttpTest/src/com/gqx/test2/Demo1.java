package com.gqx.test2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * ͨ��response����ı���Ӧ��Ϣ
		 */
			//1����Ӧ��
			//response.setStatus(404);	//�޸�״̬��
			//response.sendError(404);		//����404״̬��+404����ҳ��
		
		//2���ı���Ӧͷ
		response.setHeader("server", "JBoss");
		
		//3��ʵ������
		//	response.getWriter().write("1��hello world");	//�ַ�����
		response.getOutputStream().write("2��hello world".getBytes()); 	//�ֽ�����
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
