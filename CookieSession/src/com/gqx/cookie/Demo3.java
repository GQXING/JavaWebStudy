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
 * void setCookie(int expiry)：设置coookie的有效时间
 * 正整数：表示cookie数据保存在浏览器的缓存目录中（硬盘），数值表示保存的时间
 * 负整数：表示cookie数据保存在浏览器的内存中，浏览器关闭cookie的值就会遗失
 * 零：表示删除同名的cookie数据
 */
		Cookie cookie =new Cookie("age", "21");
		cookie.setPath("/CookieSession");
		//表示该cookie会在浏览器的硬板上存在二十秒钟，即使关闭浏览器，再打开还是一样存在
		//		cookie.setMaxAge(20); 
		//为负数，cookie会保留在内存中。又称为会话cookie（一次会话代表浏览器的关闭）
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		
		//接收cookie
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
			for (Cookie cookie2 : cookies) {
				System.out.println(cookie2.getName()+"："+cookie2.getValue());
			}
		}else {
			System.out.println("没有接收到相对应的cookie数据！");
		}
	}

}
