package com.gqx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigDemo1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ��ǰwebӦ�û����µ�ServletContext����
		ServletContext context=this.getServletContext();
		
		//�õ�webӦ�õ�·��,���������ض������Դ������
		String path=context.getContextPath();
		System.out.println(path);
		
		//�����ض��� (һ���������·��һ����,
		response.sendRedirect(path+"/index.html");
	}
}
