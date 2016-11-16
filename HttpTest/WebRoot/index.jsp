<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <form action="/HttpTest/HttpTest" method="get">
    	用户名：<input type="text" name="name"></br>
    	密  码  ：<input type="text" name="password"></br>
    	性  别  ：
    	<input type="radio" name="sex" value="男"/>男
    	<input type="radio" name="sex" value="女"/>女<br/>
    	籍  贯 ：<select name="jiguan">
    		<option value="广东">广东</option>
    		<option value="湖北">湖北</option>
    		<option value="湖南">湖南</option>
    	</select><br/>
    	爱  好 ：
    	<input type="checkbox" name="habit" value="篮球"/>篮球
    	<input type="checkbox" name="habit" value="足球"/>足球
    	<input type="checkbox" name="habit" value="棒球"/>棒球<br/>
    	<textarea rows="5" cols="10" name="info"></textarea><br/>
    	<input type="hidden" name="id" value="001">
    	<input type="submit" value="提交">
    </form>
    </hr>
    </br>
    </br>
    <form action="/HttpTest/HttpTest" method="POST">
    	用户名：<input type="text" name="name"></br>
    	密  码  ：<input type="text" name="password"></br>
    	性  别  ：
    	<input type="radio" name="sex" value="男"/>男
    	<input type="radio" name="sex" value="女"/>女<br/>
    	籍  贯 ：<select name="jiguan">
    		<option value="广东">广东</option>
    		<option value="湖北">湖北</option>
    		<option value="湖南">湖南</option>
    	</select><br/>
    	爱  好 ：
    	<input type="checkbox" name="habit" value="篮球"/>篮球
    	<input type="checkbox" name="habit" value="足球"/>足球
    	<input type="checkbox" name="habit" value="棒球"/>棒球<br/>
    	<textarea rows="5" cols="10" name="info"></textarea><br/>
    	<input type="hidden" name="id" value="001">
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
