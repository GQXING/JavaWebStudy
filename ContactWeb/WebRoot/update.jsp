<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>添加联系人</title>
    <style media="screen">
      #btn{
        width:40px;
        width: 50px;
        background: green;
        color: white;
        font-size:14px;
      }
    </style>
</head>

<body>
    <center>
        <h2>修改联系人</h2>
    </center>
    <form action="${pageContext.request.contextPath }/UpdateServlet" method="post">
        <table border="1" align="center">
            <tbody>
                
                <tr>
                    <th>姓名</th>
                    <td><input type="text" name="userName" value="${contact.name}"/></td>
                    <input type="hidden" name="id" value="${contact.id }"/>
                    
                </tr>
                <tr>
                    <th>年龄</th>
                    <td><input type="text" name="age" value="${contact.age }" /></td>
                </tr>
                <tr>
                  <th>性别</th>
                  <td>
                  	
                    <input type="radio" name="sex"  value="男" <c:if test="${contact.sex=='男' }"> checked="true"</c:if>/>男 &nbsp;
                    <input type="radio" name="sex" value="女" <c:if test="${contact.sex=='女' }"> checked="true"</c:if> />女
                  </td>
                </tr>
                <tr>
                    <th>电话</th>
                    <td><input type="text" name="phone" value="${contact.phone }" /></td>
                </tr>
                <tr>
                    <th>QQ</th>
                    <td><input type="text" name="qq" value="${contact.qq }" /></td>
                </tr>
                <tr>
                    <th>邮箱</th>
                    <td><input type="text" name="email" value="${contact.email }" /></td>
                </tr>
                <tr>
                  <td colspan="3" align="center">
                    <input type="submit"  value="提交" id="btn"/>
                  </td>
                </tr>
            </tbody>
        </table>
    </form>
</body>

</html>
