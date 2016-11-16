<%@page import="com.gqx.test.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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
	  </head> 
	<script type="text/javascript">
		window.onload=function(){
		
		//1.s获取a节点，并为其添加onclick响应函数
		document.getElementsByTagName("a")[0].onclick=function(){
		// 3、创建一个xmlhttpResquest对象
		var request=new XMLHttpRequest();	
		
		// 4、准备发送请求的数据：url
		var url=this.href+"?time="+new Date();
		var method="GET";
		
		// 5、调用xmlhttpRequest对象的open方法
		request.open(method,url);
			
		// 6、调用xmlhttpRequest对象的send方法
		request.send(null);
		
		// 7、为xmlhttpRequest对象添加onreadstatechange响应函数
		request.onreadystatechange=function(){
			
			// 8、判断响应是否完成：xmlhttprequest对象的readState的属性值为4的时候
			if(request.readyState==4){
			
				//9、在判断响应是否可用：xmlhttpRequest对象的status的属性值是200
				if(request.status==200 || request.status==304){
				
					//10、打印出响应结果：reponseText
					alert(request.responseText);
				}
			}
		}
		//2、取消a节点的默认行为
			return false;
		}	
	}
	</script>

  <body>
  <% 
  	Person person=new Person();
  	System.out.print(person.getPersonInfo());
   %>
    <a href="helloAjax.txt">HelloAjax</a>
  </body>
</html>
