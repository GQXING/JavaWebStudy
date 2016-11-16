package com.gqxing.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqx.util.SQlUtil;

public class valiateUserId extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String id=request.getParameter("userId");
		String code=request.getParameter("code");
		final String driver=
				"com.microsoft.sqlserver.jdbc.SQLServerDriver";
		final String url=
				"jdbc:sqlserver://localhost:1433;DataBaseName=教学库";
		final String user="sa";			//数据库管理员名
		final String pass="123456";		//密码
		Connection connection=null;
		PreparedStatement statement =null;
		ResultSet resultSet=null;
		String result=null;
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url,user,pass);
			String sql="select * from test where Id= ?";
			statement=connection.prepareStatement(sql);
			statement.setString(1, id);
			resultSet=statement.executeQuery();
			if (resultSet.next()) {
					int count=resultSet.getInt(1);
				if (count>0) {
					result="<font color='red'>该用户名已经被使用</font>";
				}else {
					result=" ";
				}
				response.setContentType("text/html;charset=UTF-8");		
				 response.getWriter().print(result);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQlUtil.close(connection, statement, resultSet);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
