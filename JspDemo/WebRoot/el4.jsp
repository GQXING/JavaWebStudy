<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'el4.jsp' starting page</title>
    
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
    	10+5=${10+5} <br>
    	10*5=${10*5} <br>
    	10/5=${10/5} <br>
    	<hr>
    	<%-- 比较运算 --%>
    	10>5:${10>5}<br>
    	10<5:${10<5}<br>
    	2=2:${2==2}<br>
    	<hr>
    	<%-- 逻辑运算符 --%>
    	true && false :${true && false}<br>
    	true || false :${true || false}<br>
    	!true:${!true }<br>
    	<hr>
    	<%--判断是否为空 --%>
    	<%
    		String name= "gqxing";
    		String value1=null;
    		String value2="";
    		//放进域对象中
    		pageContext.setAttribute("name", name);
    		pageContext.setAttribute("value1", value1);
    		pageContext.setAttribute("value2", value2);
    	 %>
    	${name==null}<br>
    	${value1==null}<br>
    	${value2==""}<br>
    	<%--一下两种方法去判断空字符串 --%>
    	${value1==null || value1==""}<br>
    	${empty name}<br>
    	
    	
  </body>
</html>
