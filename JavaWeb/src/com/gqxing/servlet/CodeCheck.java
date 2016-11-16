package com.gqxing.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CodeCheck extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code=request.getParameter("code");
		String result="";
		HttpSession session=request.getSession();
		System.out.println(code);
		String value=(String)session.getAttribute("rand");
		if (!code.equals(value)) {
			result="<font color='red'>ÑéÖ¤Âë´íÎó</font>";
			System.out.println("error");
		}else {
			
		}
		 response.setContentType("text/html;charset=UTF-8");
		 System.out.println(result);
		 response.getWriter().print(result);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
