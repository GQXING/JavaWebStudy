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
		//service方法用于应答请求，因为每次都会用service方法

		/*
		 * ServletRequest:封装了请求信息，可以从中获取到任何的请求信息
		 * ServletResponse：封装了响应信息，如果想给用户什么响应，具体可以该接口的方法实现
		 *
		 */
		
		String userString=request.getParameter("user");
		String password=request.getParameter("password");
		 System.out.println(userString+password);
		 
		 //String[] getParamterValues根据参数的名字，返回请求参数对应的字符串数组
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
		 
		 
		 //获取请求的url,需要强转HttpServletRequest
		 HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		 String requestURI=httpServletRequest.getRequestURI();
		 
		 System.out.println(requestURI);
		 String method=httpServletRequest.getMethod();
		 System.out.println(method);
		 StringBuffer UL=httpServletRequest.getRequestURL();
		 System.out.println(UL);
		 
		 
		 String pathString=httpServletRequest.getServletPath();
		 System.out.println(pathString);
		 
		 //ServletResponse:封装了响应信息，如果想给用户什么响应，具体可以使用该接口的方法实现
//		 PrintWriter out=response.getWriter();
//		 out.write("Hello World!");
//		 
		 
		 //1、获取请求的参数username ，password
		 
		 String userNmaeString=request.getParameter("user");
		 String passwordString=request.getParameter("password");
		 //2、获取当前web的初始化参数：username ，password
		 //使用ServletContext
		 //3、对比
		 
		 ServletContext servletContext=servletConfig.getServletContext();
		 String initName=servletContext.getInitParameter("name");
		 
		 String initPassword=servletContext.getInitParameter("password");
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out=response.getWriter();
		 
		 if (initName.equals(userNmaeString) && initPassword.equals(passwordString)) {
			out.write("你好，欢迎"+userNmaeString+"的到来");
		}else {
			out.write(userNmaeString+",你不是该用户！");
		}
		 
		 //4、打印响应字符串
	}

}
