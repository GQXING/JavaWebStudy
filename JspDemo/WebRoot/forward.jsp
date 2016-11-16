<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'forward.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
  </head>
  
  <body>
  		<%-- 作用与这个相同 
    	<%request.getRequestDispatcher("/forward2.jsp?name=gqxing").forward(request, response); %>
    	--%>
    	<jsp:forward page="/forward2.jsp">
    		<jsp:param value="gqxing" name="name"/>
    		<jsp:param value="123456" name="password"/>
    	</jsp:forward>
    	
  </body>
</html>
