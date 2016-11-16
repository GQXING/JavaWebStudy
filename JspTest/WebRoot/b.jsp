<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'b.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<h4>BBB page</h4>
    	<%
    		//1、请求转发的代码
    		//request.getRequestDispatcher("/c.jsp").forward(request, response);
    		
    		//2、请求的重定向
    		response.sendRedirect("c.jsp");
    		//response.sendRedirect("http://wwww.baidu.com");
    		//request.getRequestDispatcher("http://wwww.baidu.com").forward(request, response);
    		
    	 %>
  </body>
</html>
