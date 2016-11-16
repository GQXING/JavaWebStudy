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
 * 为cookie设置路径，同时从浏览器的发送过来的请求接收
 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie1=new Cookie("name", "gqxing");
		Cookie cookie2=new Cookie("password", "123456");
		
		/**
		 * 设置cookie的有效路径
		 * 默认情况下：有效路径在当前web应用下，/CookieSession
		 *现在设置其路径
		 */
		cookie1.setPath("/CookieSession");
		cookie2.setPath("/TestDemo");
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		
		//接收浏览器返回的cookie
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				String name=cookie.getName();
				String value=cookie.getValue();
				System.out.println(name+"："+value);
			}
		}else {
			System.out.println("没有收到cookie信息");
		}
		
		
	}

}
