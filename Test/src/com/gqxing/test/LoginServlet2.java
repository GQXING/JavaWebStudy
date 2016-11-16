package com.gqxing.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userName=request.getParameter("user");
		
		String password=request.getParameter("password");
		
		final String driver=
				"com.microsoft.sqlserver.jdbc.SQLServerDriver";
		final String url=
				"jdbc:sqlserver://localhost:1433;DataBaseName=教学库";
		
		final String user="sa";			//用户名
		final String pass="123456";		//密码
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		PrintWriter out= response.getWriter();
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url,user,pass);
			String sql="SELECT count(id) FROM users  WHERE username = ? "+
					"AND password = ?";
			statement=connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, password);
			
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int count=resultSet.getInt(1);
				
				if (count>0) {
					out.print("Hello,,,"+userName);
				}else {
					out.print("Sorry...."+userName);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	finally{
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (statement != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (connection != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
		
		
	}
}
/*



*/