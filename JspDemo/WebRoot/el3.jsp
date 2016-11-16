<%@page import="com.gqx.entity.Student"%>
<%@ page language="java" import="java.util.*,com.gqx.entity.Student"
 pageEncoding="UTF-8" isELIgnored="false"%>
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
    <%--  //list --%>
    <% List<Student> list =new ArrayList<Student>();
       list.add(new Student("gqx",21));
       list.add(new Student("gqxing",22));
       list.add(new Student("guoqingxing",22));
       pageContext.setAttribute("list", list);
     %>
     <hr>
     <%--使用EL获取List表达式 --%>
     ${list[0].name}-${list[0].age }	<br>
     ${list[1].name}-${list[1].age }	<br>
     ${list[2].name}-${list[2].age }	<br>
     <hr>
     <%--等价于 --%>
     <%=((Student)((List)pageContext.findAttribute("list")).get(0)).getName() %>
     
     <hr>
    <% //MAP
    	Map<String,Student> map=new HashMap<String,Student>();
    	map.put("001", new Student("gqx",21));
    	map.put("002", new Student("gqxing",22));
    	map.put("003", new Student("guoqingxing",22));
		//放入到域中去
		pageContext.setAttribute("map", map);
     %>
     
     <%--使用EL获取List表达式 --%>
     ${map['001'].name}-${map['001'].age }	<br>
     ${map['002'].name}-${map['002'].age }	<br>
     ${map['003'].name}-${map['003'].age }	<br>
     
     
     
  </body>
</html>
