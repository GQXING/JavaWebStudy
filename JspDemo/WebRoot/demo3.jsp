<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="true"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'demo3.jsp' starting page</title>
    
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
    	<%// out.print(session==pageContext.getSession()); %>
    	<%
    	//pageContext作为域对象去保存数据
    	pageContext.setAttribute("message", "i am coming");
    	pageContext.setAttribute("message", "我是pageContext中设置的request域中的值，i am coming", pageContext.REQUEST_SCOPE);
    	//request.setAttribute("name", "gqxing");		//等价于上面的代码
    	
    	request.setAttribute("value", "request's value");
    	 %>
    	 <hr>
    	 <%--
    	 	原则：在那个域中保存数据，必须在哪个域中取数据。
    	  --%>
    	 <%
    	 	//获取数据
    	 	String message=(String)pageContext.getAttribute("message");
    	 	out.print(message+"<hr>");
    	 	String name=(String)request.getAttribute("message");
    	 	out.print(name);
    	  %>
    	  
    	   <hr>
    	   <span>用pageContext中的request域去取request域中设置的值（request.setAttribute("value", "request's value");）</span>
    	   <% String value=(String)pageContext.getAttribute("message", pageContext.REQUEST_SCOPE);
    	   	  out.print(value);
    	    %>
    	    <hr><span>用findattribute去查找:</span>
    	    <%--
    	    	findAttribute：自动搜索功能
    	    	顺序：page域(pageContext)——>request域——>session域——>application域。
    	    	 --%>
    	    <%
    	    	String name3=(String)pageContext.findAttribute(message);
    	    	out.print(name);
    	     %>
  </body>
</html>
