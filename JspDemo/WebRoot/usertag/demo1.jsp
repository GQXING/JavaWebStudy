<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.gqxing.com" prefix="gqx" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>自定义标签</title>
  </head>
  <body>
  <%-- 
   	<%	//获取当前用户的IP地址
   		String ip=request.getRemoteHost();
   		out.print("当前用户的IP地址是:"+ip); 	
   	 %>	
   	 --%>
   	 <gqx:showIp>gqx</gqx:showIp>
  </body>
</html>
