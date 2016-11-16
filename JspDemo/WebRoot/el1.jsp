<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  </head>
  <body>
    <% 
    	//放入域对象中
    	pageContext.setAttribute("name", "gqxing");
     %>
     <%--下面代码等价于pageContext.findAttribute("name") --%>
     ${name}
     <br>
     <%--也可以从指定的域中获取数据  等价于 pageContext.getAttribute("name",pageContext.pageScope--%>
     ${pageScope.name} 
  </body>
</html>
