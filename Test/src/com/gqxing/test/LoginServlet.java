package com.gqxing.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	private ServletConfig servletConfig;
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.servletConfig=servletConfig;
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//service��������Ӧ��������Ϊÿ�ζ�����service����

		/*
		 * ServletRequest:��װ��������Ϣ�����Դ��л�ȡ���κε�������Ϣ
		 * ServletResponse����װ����Ӧ��Ϣ���������û�ʲô��Ӧ��������Ըýӿڵķ���ʵ��
		 *
		 */
		
		String userString=request.getParameter("user");
		String password=request.getParameter("password");
		 System.out.println(userString+password);
		 
		 //String[] getParamterValues���ݲ��������֣��������������Ӧ���ַ�������
		 String interesting=request.getParameter("interesting");
		 System.out.println(interesting);
		 
		 String[] interestings=request.getParameterValues("interesting");
		 for(String str:interestings){
			 System.out.println("-->"+str);
		 }
		 
		 Enumeration<String> names=request.getParameterNames();
		 while (names.hasMoreElements()) {
			String valueString=names.nextElement();
			String val=request.getParameter(valueString);
			System.out.println(valueString+":"+val);
		}
		 
		 Map<String, String[]> map=request.getParameterMap();
		 for(Map.Entry<String, String[]>entry:map.entrySet()){
			 System.out.println("Map++++++++"+entry.getKey()+":"+Arrays.asList(entry.getValue()));
		 }
		 
		 
		 //��ȡ�����url,��ҪǿתHttpServletRequest
		 HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		 String requestURI=httpServletRequest.getRequestURI();
		 
		 System.out.println(requestURI);
		 String method=httpServletRequest.getMethod();
		 System.out.println(method);
		 StringBuffer UL=httpServletRequest.getRequestURL();
		 System.out.println(UL);
		 
		 
		 String pathString=httpServletRequest.getServletPath();
		 System.out.println(pathString);
		 
		 //ServletResponse:��װ����Ӧ��Ϣ���������û�ʲô��Ӧ���������ʹ�øýӿڵķ���ʵ��
//		 PrintWriter out=response.getWriter();
//		 out.write("Hello World!");
//		 
		 
		 //1����ȡ����Ĳ���username ��password
		 
		 String userNmaeString=request.getParameter("user");
		 String passwordString=request.getParameter("password");
		 //2����ȡ��ǰweb�ĳ�ʼ��������username ��password
		 //ʹ��ServletContext
		 //3���Ա�
		 
		 ServletContext servletContext=servletConfig.getServletContext();
		 String initName=servletContext.getInitParameter("name");
		 
		 String initPassword=servletContext.getInitParameter("password");
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out=response.getWriter();
		 
		 if (initName.equals(userNmaeString) && initPassword.equals(passwordString)) {
			out.write("��ã���ӭ"+userNmaeString+"�ĵ���");
		}else {
			out.write(userNmaeString+",�㲻�Ǹ��û���");
		}
		 
		 //4����ӡ��Ӧ�ַ���
	}

}
