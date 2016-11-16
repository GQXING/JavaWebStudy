<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'success.jsp' starting page</title>
  </head>
  <script type="text/javascript">
 	var second=5000;
	window.setInterval(function(){
	document.getElementById("time").innerHTML=second/1000;
 				second =second-1000;
 				document.getElementById("time").innerHTML=second/1000;
			}, 1000);
	</script>
  <body>
    <h2>注册成功</h2>
    <h3>还剩<span id="time">5</span>秒跳转</h3>
    <% response.setHeader("refresh", "5;url="+request.getContextPath()+"/work1/user.jsp"); %> 
  </body>
</html>
