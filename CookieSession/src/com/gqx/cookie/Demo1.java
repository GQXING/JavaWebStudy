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
		//1、创建Cookie对象
		Cookie cookie=new Cookie("name", "gqxing");
		
		//2、把cookie数据发送给浏览器(通过响应头发送：set-cookie)
		//		response.setHeader("set-cookie",cookie.getName()+"="+cookie.getValue());
		//以上方法太过于麻烦，以下方法直接以键值对的形式将cookie发送（推荐）
		response.addCookie(cookie);
		
		//3、接受浏览器返回的cookie信息
		//		String  cookieValue=request.getHeader("cookie");
		//以上方法不面向对象，使用下面方法
		Cookie[] cookies=request.getCookies();
		//注意需要判断是否为空
		if (cookies!=null) {
			for (Cookie cookie2 : cookies) {
				String name=cookie2.getName();
				String value=cookie2.getValue();
				System.out.println(name+"="+value);
			}
		}else {
			System.out.println("没有接收到cookie数据");
		}
		
	}

}
