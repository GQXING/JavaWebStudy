package com.gqx.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1������Cookie����
		Cookie cookie=new Cookie("name", "gqxing");
		
		//2����cookie���ݷ��͸������(ͨ����Ӧͷ���ͣ�set-cookie)
		//		response.setHeader("set-cookie",cookie.getName()+"="+cookie.getValue());
		//���Ϸ���̫�����鷳�����·���ֱ���Լ�ֵ�Ե���ʽ��cookie���ͣ��Ƽ���
		response.addCookie(cookie);
		
		//3��������������ص�cookie��Ϣ
		//		String  cookieValue=request.getHeader("cookie");
		//���Ϸ������������ʹ�����淽��
		Cookie[] cookies=request.getCookies();
		//ע����Ҫ�ж��Ƿ�Ϊ��
		if (cookies!=null) {
			for (Cookie cookie2 : cookies) {
				String name=cookie2.getName();
				String value=cookie2.getValue();
				System.out.println(name+"="+value);
			}
		}else {
			System.out.println("û�н��յ�cookie����");
		}
		
	}

}
