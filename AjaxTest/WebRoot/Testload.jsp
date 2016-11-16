<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Testload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript" src="javascripts/jquery-1.10.1.js"></script>
  <script type="text/javascript">
  	$(function(){
  		
	  	$("a").click(function(){
	  		//使用load方法处理Ajax
	  		var url=this.href;
	  		var args={"time":new Date()};
	  		$("#content").load(url,args);
	  		return false;
  		});
  	
  	});
  	
  </script>
  <body>
    <a href="helloAjax.txt">HelloAjax</a>
    <div id="content"></div>
  </body>
</html>
