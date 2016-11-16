<%@page import="java.text.SimpleDateFormat"%>
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
  </head>
  <body>
    <% SimpleDateFormat date=new SimpleDateFormat();
    	String curDate=date.format(new Date());
    	out.write("现在时间是："+curDate);
     %>
     </br>
     2*3=<%=(2*3) %>
     </br>
     
     <% Random random=new Random();
     	float f=random.nextFloat();
      %>
      <%=f %>
      <%--声明成员变量（全局变量） --%>
      <%! String name="gqxing";%>
  </body>
</html>
