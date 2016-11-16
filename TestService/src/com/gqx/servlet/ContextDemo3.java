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
				//1.得到域对象
				ServletContext context = this.getServletContext();
				
				//2.从域对象中取出数据
				//String name = (String)context.getAttribute("name");
				Student student = (Student)context.getAttribute("student");
				//System.out.println("user="+name);
				
				System.out.println(student);
	}

}
