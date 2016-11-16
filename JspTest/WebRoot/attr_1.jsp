<%@page import="javax.xml.crypto.Data"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'attr_1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
    <% 
    	pageContext.setAttribute("pageContextAttr", "pageContextValue");
    	request.setAttribute("requestAttr", "requestValue");
    	session.setAttribute("sessionAttr", "sessionValue");
    	application.setAttribute("applicationAttr", "applicationValue");
     %>
     
     <h2>Attr 1 Page<%=new Date() %></h2>
     <br><br>
     pageContextAttr : <%=pageContext.getAttribute("pageContextAttr") %>
     
     <br><br>
     requestAttr : <%=request.getAttribute("requestAttr") %>
     
     <br><br>
     sessionAttr : <%=session.getAttribute("sessionAttr") %>
     
     <br><br>
     application : <%=application.getAttribute("applicationAttr") %>
     <br><br>
     <a href="attr_2.jsp">To Attr_2</a>
     
      <br><br>
     <a href="testAttr">To Attr Servlet</a>
     
     
     <br><br>
     
     <%
     	request.getRequestDispatcher("/attr_2.jsp").forward(request, response);
      %>
     
     
  </body>
</html>
