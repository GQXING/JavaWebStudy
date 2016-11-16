<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'x.jsp' starting page</title>
    
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
  <%String str="hello";%>
    This is my JSP page. <br>
    <h2>XXXXXX Page</h2>
    <!-- 在x.jsp中包含y.jsp -->
    <%-- 
    <jsp:include page="y.jsp"></jsp:include>
    request.getRequestDispatcher("/include/y.jsp").forward(request, response);
     
    --%>
    <jsp:forward page="/include2/y.jsp">
    	<jsp:param value="abcd" name="userName"/>
    </jsp:forward>
    
    
   <%
   	
    %>
  </body>
</html>
