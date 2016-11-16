<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.gqxing.com" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>My JSP 'chooseTag.jsp' starting page</title>
   </head> 
  <body>
    <c:choose>
    	<c:when test="${10<5}">你通过啦！！！哈哈</c:when>
    	<c:Otherwise>不开心，没有通过呢！！！</c:Otherwise>
    </c:choose>
  </body>
</html>
