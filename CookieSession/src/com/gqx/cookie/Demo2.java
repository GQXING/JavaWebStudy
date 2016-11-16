package com.gqx.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

public class Demo2 extends HttpServlet {
/**
 * Ϊcookie����·����ͬʱ��������ķ��͹������������
 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie1=new Cookie("name", "gqxing");
		Cookie cookie2=new Cookie("password", "123456");
		
		/**
		 * ����cookie����Ч·��
		 * Ĭ������£���Ч·���ڵ�ǰwebӦ���£�/CookieSession
		 *����������·��
		 */
		cookie1.setPath("/CookieSession");
		cookie2.setPath("/TestDemo");
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		
		//������������ص�cookie
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				String name=cookie.getName();
				String value=cookie.getValue();
				System.out.println(name+"��"+value);
			}
		}else {
			System.out.println("û���յ�cookie��Ϣ");
		}
		
		
	}

}
