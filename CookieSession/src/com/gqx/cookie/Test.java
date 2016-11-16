package com.gqx.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");		
		//获取当前时间
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time =format.format(new Date());
		Cookie cookie =new Cookie("lastTime", time);
		cookie.setPath("/CookieSession");
		cookie.setMaxAge(1*30*24*60*60);
		response.addCookie(cookie);
		
		
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
			response.getWriter().write("<html><body><p>欢迎回来，你上次访问的时间是："+cookies[0].getValue()+"      "+"当前时间是："+time+"</p></body></html>");
			cookie.setValue(time);
			cookie.setMaxAge(1*30*24*60*60);
			response.addCookie(cookie);
		}else {
			response.getWriter().write("<html><body><p>你是首次访问本网站，当前时间是："+time+"</p></body></html>");
		}
	}

}
