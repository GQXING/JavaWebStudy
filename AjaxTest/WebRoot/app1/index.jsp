<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
     <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
    <script type="text/javascript" src="../javascripts/jquery-1.10.1.js"></script>
    <script type="text/javascript">
    $(function(){
    	$(":input[name='username']").change(function(){
    		var val=$(this).val();
    		//去除空格
    		val=$.trim(val);
    		
    		if(val !=""){
    	
    			var url="../valiateUserName";
    			var args={"userName":val,"time":new Date()};
    			$.post(url,args,function(data){
    				$("#message").html(data);
    			});
    		}
    	})
    
    })
    
    </script>
  <body>
   	<form action="" method="post">
   		UserName:<input type="text" name="username">
   		<br>
   		<div id="message"></div>
   		<br>
   		<input type="submit" value="查询">
   	</form>
  </body>
</html>
