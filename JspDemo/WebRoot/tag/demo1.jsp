<%@ page language="java" import="java.util.*,com.gqx.entity.Student" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'demo1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <%--使用标签 --%>
    <%--set标签保存数据（数据保存到域对象,默认保存page域中） 
    <c:set var="name" value="gqxing" scope="request"></c:set>
    ${requestScope.name}
     --%>
     
    <% 
    	String name=null;
    	pageContext.setAttribute("name", name);
    %>
    <%--out标签：获取数据
    	default:当value值为空的时候使用默认值
    	而单纯的el表达式没有这个功能‘
    	escapeXml="":是否对value值进行转移，默认为true，即进行转义
     --%>
    <c:out value="${name}" default="<h3>标签</h3>" escapeXml="false"></c:out>
    <%--if 标签：单条件判断 --%>
    <c:if test="${10>5}">
    	<h2>条件成立</h2>
    </c:if>
    <c:if test="${!empty name }">
    	是空值
    </c:if>
    <hr>
    <%--choose+when+otherwise标签，多条件判断 --%>
    <c:set var="score" value="95"></c:set>
    <c:choose>
    	<c:when test="${score>=90 && score<=100}">优秀</c:when>
    	<c:when test="${score>=80 && score<90}">良好</c:when>
    	<c:when test="${score>=60 && score<80}">及格</c:when>
    	<c:otherwise>不及格</c:otherwise>
    </c:choose>
    <hr>
    <%--foreach 循环
    	begin:指定从哪开始，默认为0
    	end：指定的终止位置
    	step:指定的步长 形如for(i=1;i<10;i++)的i++
    	items:需要遍历的数据，通常是集合
    	var:每个元素起的名称，为了在循环体中可以取用
    	varStatus:当前正在遍历元素的状态对象。(count属性:当前位置，从1开始）
     --%>
    <% List<Student> list =new ArrayList<Student>();
       list.add(new Student("gqx",21));
       list.add(new Student("gqxing",22));
       list.add(new Student("guoqingxing",22));
       pageContext.setAttribute("list", list);
     %>
     <c:forEach begin="0" end="2" step="1" items="${list}" var="student" varStatus="varSta">
    	序号:${varSta.count}——姓名：${student.name}——年龄：${student.age}<br>
     </c:forEach>
     <hr>
      <% //MAP
    	Map<String,Student> map=new HashMap<String,Student>();
    	map.put("001", new Student("gqx",21));
    	map.put("002", new Student("gqxing",22));
    	map.put("003", new Student("guoqingxing",22));
		//放入到域中去
		pageContext.setAttribute("map", map);
     %>
     <c:forEach begin="0" end="2" step="1" items="${map }" var="entry" varStatus="varStar">
     	序号：${entry.key }——姓名:${entry.value.name }——年龄：${entry.value.age }<br>
     </c:forEach>
     <hr>
     <%--forToken:循环特殊的字符串 --%>
     <%
     	String str="java-php-net-photoship-c++";
     	pageContext.setAttribute("str", str);
      %>
     <c:forTokens items="${str }" delims="-" var="s" varStatus="varStar">
     	${varStar.count }——${s }<br>
     </c:forTokens>
     
     
  </body>
</html>
