package com.gqx.homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TryTest extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ÃÌº”contact±Í«©

		
	Enumeration<String> enums=request.getParameterNames();
	while (enums.hasMoreElements()) {
			String para = (String) enums.nextElement();
			String value=request.getParameter(para);
			value=new String(value.getBytes("iso-8859-1"),"utf-8");
			System.out.println(para+":"+value);
		}
	}

}
