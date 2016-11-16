<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
   page:<%=pageContext.getAttribute("message") %>
   <hr>
   request:<%=pageContext.getAttribute("message",pageContext.REQUEST_SCOPE) %>
   <hr>
   session:<%=pageContext.getAttribute("message",pageContext.SESSION_SCOPE) %>
   <hr>
   application(context):<%=pageContext.getAttribute("message",pageContext.APPLICATION_SCOPE) %>
  </body>
</html>
