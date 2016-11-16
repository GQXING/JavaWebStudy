<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hello.jsp' starting page</title>
    
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
    This is Hello's JSP page. <br>
    <br><br>
    <%
    	request.setCharacterEncoding("UTF-8");
     %>
     <%-- 
     
     
    	String val=request.getParameter("user");
    	String username=new String(val.getBytes("iso-8859-1"),"UTF-8");
    	out.print(username);
     %>
    --%>
  
    userName:<%=request.getParameter("user")%>
    
  </body>
</html>
