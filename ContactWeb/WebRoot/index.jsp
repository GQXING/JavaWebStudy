<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <title>查询所有联系人</title>
    <style media='screen'>
        table td {
            text-align: center;
        }

        table {
            border-collapse: collapse;
        }
    </style>
</head>

<body>
    <center>
        <h2>查询所有联系人</h2>
    </center>
    <table border='1' align='center'>
        <tbody>
            <thead>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>电话</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </thead>
           <c:forEach items="${contacts}" var="con"  varStatus="varSta">
            <tr>
                <td>${varSta.count }</td>
                <td>${con.name }</td>
                <td>${con.sex }</td>
                <td>${con.age }</td>
                <td>${con.phone }</td>
                <td>${con.qq }</td>
                <td>${con.email }</td>
                <td><a href='${pageContext.request.contextPath }/FindIdServlet?id=${con.id}'>修改</a>&nbsp;&nbsp;<a href='${pageContext.request.contextPath }/DeleteServlet?id=${con.id}'>删除</a></td>
            </tr>
            </c:forEach>
            <tr>
                <td colspan='8'>
                    <a href='${pageContext.request.contextPath}/add.jsp'>添加联系人</a>
                </td>
            </tr>
        </tbody>
    </table>
</body>

</html>
