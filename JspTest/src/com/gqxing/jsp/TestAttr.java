package com.gqxing.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestAttr extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//1/、在servlet中无法获取pageContext对象
		
		// 2、request
		Object requestAttr = request.getAttribute("requestAttr");
			out.print("requestAttr"+requestAttr);
			out.print("<br><br>");
			
			//3、session
			Object sessionAttr = request.getSession().getAttribute("sessionAttr");
			
			out.print("sessionAttr"+sessionAttr);
			out.print("<br><br>");
			
			//3、application
			Object applicationAttr =getServletContext().getAttribute("applicationAttr");
			out.print("applicationAttr"+applicationAttr);
			out.print("<br><br>");
	}

}
