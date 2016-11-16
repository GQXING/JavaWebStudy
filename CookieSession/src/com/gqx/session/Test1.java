package com.gqx.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 保存会话的数据
 * @author Administrator
 *
 */
public class Test1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		//设置该cookie的有效时间
//		Cookie cookie =new Cookie("JSESSIONID", session.getId());
//		cookie.setMaxAge(60*60);
//		response.addCookie(cookie);
		session.setAttribute("name", "gqxing");
		session.setAttribute("value", "123456");
		System.out.println(session.getId());
	}

}
