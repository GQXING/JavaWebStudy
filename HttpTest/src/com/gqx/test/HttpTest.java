package com.gqx.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * ���ò�ѯ��������
		 * �÷���ֻ�ܶ�����ʵ�����ݵ����ݱ��������á�post�ύ�����������������У����Ը÷�����post��Ч
		 * ��get��ʽ��Ч,����Ҫ��get���±���
		 */
		request.setCharacterEncoding("utf-8");
		Enumeration<String> names=request.getParameterNames();
		while (names.hasMoreElements()) {
			
			String string = (String) names.nextElement();
			if (string.equals("habit")) {
				String[] habit=request.getParameterValues("habit");
				System.out.print(string+":");
				for (String string1 : habit) {
					if (request.getMethod().equals("GET")) {
						//�ֶ����±��루iso-8859-1�ַ�������>utf-8�ַ�����
						string1=new String(string1.getBytes("iso-8859-1"),"utf-8");
					}
					System.out.print(string1+" ");
				}
				System.out.println();
			}else {
				
				String value=request.getParameter(string);
				if (request.getMethod().equals("GET")) {
					//�ֶ����±��루iso-8859-1�ַ�������>utf-8�ַ�����
					value=new String(value.getBytes("iso-8859-1"),"utf-8");
				}
				System.out.println(string+":"+value);
			}
		}
	}
	//����post��ʽ������
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
