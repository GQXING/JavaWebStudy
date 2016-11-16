<%@ page language="java" import="java.util.*" 
pageEncoding="UTF-8" buffer="3kb" isErrorPage="true"%>
<%	
	System.out.println(out.getRemaining());
	for(int i=1;i<=1024;i++)
	out.write("a");
	//查看缓冲区的大小
	response.getWriter().write("郭庆兴");
 %>
