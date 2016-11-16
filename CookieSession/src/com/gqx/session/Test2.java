package com.gqx.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 接受会话的数据
 * @author Administrator
 *
 */
public class Test2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//如果是同一个session对象就返回一个HttpSession对象，否则返回空
		HttpSession session=request.getSession(false);
		
		if (session!=null) {
			String value=(String) session.getAttribute("name");
			String value2=(String) session.getAttribute("value");
			System.out.println("name : "+value);
			System.out.println("value:"+value2);
			System.out.println(session.getId());
		}else {
			System.out.println("此处没有拿到相同的session对象");
		}
		
	}

}
