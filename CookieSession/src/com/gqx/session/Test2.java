package com.gqx.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ���ܻỰ������
 * @author Administrator
 *
 */
public class Test2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//�����ͬһ��session����ͷ���һ��HttpSession���󣬷��򷵻ؿ�
		HttpSession session=request.getSession(false);
		
		if (session!=null) {
			String value=(String) session.getAttribute("name");
			String value2=(String) session.getAttribute("value");
			System.out.println("name : "+value);
			System.out.println("value:"+value2);
			System.out.println(session.getId());
		}else {
			System.out.println("�˴�û���õ���ͬ��session����");
		}
		
	}

}
