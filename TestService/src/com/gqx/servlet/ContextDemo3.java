package com.gqx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				//1.�õ������
				ServletContext context = this.getServletContext();
				
				//2.���������ȡ������
				//String name = (String)context.getAttribute("name");
				Student student = (Student)context.getAttribute("student");
				//System.out.println("user="+name);
				
				System.out.println(student);
	}

}
