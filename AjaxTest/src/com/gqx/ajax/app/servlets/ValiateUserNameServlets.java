package com.gqx.ajax.app.servlets;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValiateUserNameServlets extends HttpServlet {	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			java.util.List<String> userNames=Arrays.asList("AAA","BBB","CCC");
			String userName=request.getParameter("userName");
			String result=null;
			if (userNames.contains(userName)) {
				result="<font color='red'>���û����Ѿ���ʹ��</font>";
			}else {
				result="<font color='blue'>���û�������ʹ��</font>";
			}
			 response.setContentType("text/html;charset=UTF-8");		
			 response.getWriter().print(result);
	}	
}
