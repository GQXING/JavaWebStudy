package com.gqxing.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadDemo2 extends HttpServlet {
	
	/**
	 * ���̰߳�ȫ����
	 * ������������վ�ĵڼ�������
	 */
	int count=1;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//Ϊ��ǰ���ʵ��̼߳���,
		synchronized (ThreadDemo2.class) {//���̱߳�����Ψһ�ģ������õ�ǰ���ֽ������
			response.getWriter().write("�������ǵ�ǰ��վ�ĵ�"+count+"���ÿͣ�");
		}	
		count++;
	}

}
