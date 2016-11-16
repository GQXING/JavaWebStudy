package com.gqx.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 设置查询参数编码
		 * 该方法只能对请求实体内容的数据编码起作用。post提交的数据在试题内容中，所以该方法对post有效
		 * 对get方式无效,所以要对get重新编码
		 */
		request.setCharacterEncoding("utf-8");
		Enumeration<String> names=request.getParameterNames();
		while (names.hasMoreElements()) {
			
			String string = (String) names.nextElement();
			if (string.equals("habit")) {
				String[] habit=request.getParameterValues("habit");
				System.out.print(string+":");
				for (String string1 : habit) {
					if (request.getMethod().equals("GET")) {
						//手动重新编码（iso-8859-1字符串——>utf-8字符串）
						string1=new String(string1.getBytes("iso-8859-1"),"utf-8");
					}
					System.out.print(string1+" ");
				}
				System.out.println();
			}else {
				
				String value=request.getParameter(string);
				if (request.getMethod().equals("GET")) {
					//手动重新编码（iso-8859-1字符串——>utf-8字符串）
					value=new String(value.getBytes("iso-8859-1"),"utf-8");
				}
				System.out.println(string+":"+value);
			}
		}
	}
	//接收post方式的请求
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
