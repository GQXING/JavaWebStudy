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
		//��ȡ����
//		String name=(String) request.getAttribute("userName");
		//��ȡsession�������
		HttpSession session=request.getSession(false);
		if (session==null) {
			//û�е���ɹ�����һ�η��ʱ�ҳ�棬����û�ж�Ӧ��JSESSIONID,��,��������ҳ��ȥ
			response.sendRedirect(request.getContextPath()+"/login.html");
			return ;
		}
		//ȡ���Ự����
		String name=(String) session.getAttribute("userName");
		if (name==null) {
			//���û�ע����ʱ�򣬲�û�н�sessionɾ����ֻɾ����name���п���������Ҫ����Ϣ��������session�У��ʲ���ֱ��ɾ������
			//���ʱ�򣬻���Ҫ�ڷ��ص���ҳ��֤
			response.sendRedirect(request.getContextPath()+"/login.html");
			return;
		}
		String html="<html><body>��ӭ������"+name+"��<a href="+request.getContextPath()+"/LogoutServlet>ע������</a></body></html>";
		write.write(html);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
