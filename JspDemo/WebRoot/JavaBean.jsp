<%@ page language="java" import="java.util.*,com.gqx.entity.Student" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'JavaBean.jsp' starting page</title>
  </head>
  
  <body>
  	<%--  在jsp中创建实体对象
  	<%
  		Student student =new Student();
  		student.setName("gqxing");
  		student.setAge(21);
  	 %>
  	  --%>
  	<%--创建实体对象 --%>
    <jsp:useBean id="stu" class="com.gqx.entity.Student"></jsp:useBean>
    <%--复制 --%>
    <jsp:setProperty property="name" name="stu" value="gqxing"/>
    <jsp:getProperty property="name" name="stu"/>
  </body>
</html>
