<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
<head>
<base href="<%=basePath%>">
<title>猜数字游戏</title>

</head>
<body>
	<%
    			String value=(String)request.getAttribute("answer");
    			Integer times = (Integer)request.getAttribute("times");
  	 			
    %>
	<i><h1>请猜猜这个数字</h1>
	<hr>
	<form action="<%=request.getContextPath()%>/GuessServlet" method="post">

		<input type="text" name="number"> <input type="submit"
			value="确定">
		<%
    		if(times!=null){
    	 %>
		<input type="hidden" name="times" value="<%=times %>" />
		<%
    		if(value.equals("=")){
    			out.print("<p style='color:green'>啦啦啦，恭喜你答对啦，");
    		}else{
    			out.print("<p style='color:red'>你还有"+(5-times)+"次机会！同时你猜的有点"+value);
    		}
    	
    	%></p>
		<%
    	}
    	 %>
	</form> </i>
</body>
	</html>