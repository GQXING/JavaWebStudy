<%@ page language="java" import="java.util.*,com.gqx.entity.Student" pageEncoding="UTF-8" isELIgnored="false"%>
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
   	<%--用el去输出对象的属性 --%>
   	<%	//保存对象
   		Student student = new Student("gqx",21);
   		pageContext.setAttribute("student", student);
   	 %>
   	 <%--使用域对象去获取数据 --%>
   	 ${student.name}——${student.age}
   	 <%-- 等价于((Student)pageContext.findAttribute("student")).getName()--%>
   	 <hr>
   	 <%=((Student)pageContext.findAttribute("student")).getName() %>
  </body>
</html>
