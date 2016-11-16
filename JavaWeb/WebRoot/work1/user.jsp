<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String time =format.format(new Date());
    pageContext.setAttribute("time", time);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎您的来访</title>
    
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
  		<p>今天是：${time}</p>
    	<h2>欢迎您的到来
    	<c:choose>
    	<c:when test="${!empty sessionScope.userName}">：${sessionScope.userName }
    	<hr>
    		<i>以下是您的详细信息：</i>
    		<p>账号：${sessionScope.Id }</p>
    		<p>性别：${sessionScope.sex }</p>
    	</c:when>
    	<c:otherwise>：亲，您还未登入，请先去<a href="<%=request.getContextPath()%>/work1/login.html">登入</a></c:otherwise>
    	</c:choose>
    	</h2>
    	
  </body>
</html>
