<%@ page language="java"
 import="java.util.*" 
 pageEncoding="UTF-8"
 isErrorPage="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
    亲，系统发生错误，管理员正在抢救中。<br>
    错误原因：<%=exception.getMessage() %>
  </body>
</html>
