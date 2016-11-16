package com.gqx.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/**
 * void setCookie(int expiry)������coookie����Чʱ��
 * ����������ʾcookie���ݱ�����������Ļ���Ŀ¼�У�Ӳ�̣�����ֵ��ʾ�����ʱ��
 * ����������ʾcookie���ݱ�������������ڴ��У�������ر�cookie��ֵ�ͻ���ʧ
 * �㣺��ʾɾ��ͬ����cookie����
 */
		Cookie cookie =new Cookie("age", "21");
		cookie.setPath("/CookieSession");
		//��ʾ��cookie�����������Ӳ���ϴ��ڶ�ʮ���ӣ���ʹ�ر���������ٴ򿪻���һ������
		//		cookie.setMaxAge(20); 
		//Ϊ������cookie�ᱣ�����ڴ��С��ֳ�Ϊ�Ựcookie��һ�λỰ����������Ĺرգ�
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		
		//����cookie
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
			for (Cookie cookie2 : cookies) {
				System.out.println(cookie2.getName()+"��"+cookie2.getValue());
			}
		}else {
			System.out.println("û�н��յ����Ӧ��cookie���ݣ�");
		}
	}

}
