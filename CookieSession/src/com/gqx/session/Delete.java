package com.gqx.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Delete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();
		
		if (session!=null) {
			session.invalidate();  		//�ֶ�����
			System.out.println("���ٳɹ�");
		}else {
			System.out.println("����ʧ�ܣ�");
		}
	}

}
