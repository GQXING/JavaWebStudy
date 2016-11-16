package com.gqx.SessionDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	/**
	 * �����¼���߼�
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("userName");
		String password=request.getParameter("password");

		if (name.equals("gqxing") && password.equals("123456")) {
			//����ɹ�
			/*
			 *  context����󣺲����ʣ����ܻḲ�����ݡ�
			 *  ���ȼ�������request�������ʵ��ҳ�����תҳ�����ݵĹ���
			 */
			
			
			//				request.setAttribute("userName", name);		//��ӱ��湲�������															
			//				 request.getRequestDispatcher("/IndexServlet").forward(request, response);  //�����ת��

			HttpSession session=request.getSession();
			session.setAttribute("userName", name);
			//���ʱ������õ��ض�����
			System.out.println("��֤�ɹ�");
			response.sendRedirect(request.getContextPath()+"/IndexServlet");

		}else {
			//����ʧ�ܣ��ض�������ԭҳ��
			response.sendRedirect(request.getContextPath()+"/fail.html");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
