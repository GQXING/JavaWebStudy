package com.gqx.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookie extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ͬһ��·���µ�ͨ���Ƶ�cookieɾ����
		////Ҫע�����ֻҪcookie��������ͬ�ͺþͺã����������cookie�����ֽ�����age��,ע��������Ĵ���������Ҳ����ͬ���ġ�age��
		Cookie cookie=new Cookie("age", "XXX");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		System.out.println("ɾ���ɹ���");
	}

}
