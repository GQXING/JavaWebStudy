<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'demo4.jsp' starting page</title>
  </head>
  <body>
  <%--数据的保存面 --%>
    <%pageContext.setAttribute("messsage", "page'vale",pageContext.PAGE_SCOPE);
      pageContext.setAttribute("message", "request'value",pageContext.REQUEST_SCOPE);
      pageContext.setAttribute("message", "session'value",pageContext.SESSION_SCOPE);
      pageContext.setAttribute("message", "context'value", pageContext.APPLICATION_SCOPE);
     %>   
     <%
     	//request.getRequestDispatcher("/demo5.jsp").forward(request, response);
     	response.sendRedirect(request.getContextPath()+"/demo5.jsp");
      %>
  </body>
</html>
