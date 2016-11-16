<%@ page language="java" import="java.util.*,com.gqx.entity.Student" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.gqxing.com" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'foreach.jsp' starting page</title> 
  </head>
  
  <body>
     <%
       //保存数据
       //List
     	List<Student>  list = new ArrayList<Student>();
     	list.add(new Student("rose",18));
     	list.add(new Student("jack",28));
     	list.add(new Student("lucy",38));
     	//放入域中
     	pageContext.setAttribute("list",list);
     	
     %>
     
     <c:forEach items="${list}" var="student">
     		姓名：${student.name } - 年龄:${student.age }<br/>
     </c:forEach>
     
     <c:forEach items="${map}" var="entry">
     	  编号：${entry.key} - 姓名：${entry.value.name} - 年龄：${entry.value.age }<br/>
     </c:forEach>

     
  </body>
</html>
