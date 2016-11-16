package com.gqx.SessionDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	
		PrintWriter write=response.getWriter();
		//获取属性
//		String name=(String) request.getAttribute("userName");
		//获取session对象对象
		HttpSession session=request.getSession(false);
		if (session==null) {
			//没有登入成功（第一次访问本页面，或是没有对应的JSESSIONID,）,跳到登入页面去
			response.sendRedirect(request.getContextPath()+"/login.html");
			return ;
		}
		//取出会话数据
		String name=(String) session.getAttribute("userName");
		if (name==null) {
			//当用户注销的时候，并没有将session删除，只删除了name（有可能其他必要的信息保存在了session中，故不可直接删除），
			//这个时候，还需要在返回登入页验证
			response.sendRedirect(request.getContextPath()+"/login.html");
			return;
		}
		String html="<html><body>欢迎回来，"+name+"，<a href="+request.getContextPath()+"/LogoutServlet>注销登入</a></body></html>";
		write.write(html);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
