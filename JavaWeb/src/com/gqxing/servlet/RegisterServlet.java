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

public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String userId=request.getParameter("userId");
		String userName=request.getParameter("userName");
		userName=new String(userName.getBytes("iso-8859-1"),"utf-8");
		String sex=request.getParameter("sex");
		sex=new String(sex.getBytes("iso-8859-1"),"utf-8");
		String password=request.getParameter("password");
		final String driver=
				"com.microsoft.sqlserver.jdbc.SQLServerDriver";
		final String url=
				"jdbc:sqlserver://localhost:1433;DataBaseName=教学库";
		final String user="sa";			//数据库管理员名
		final String pass="123456";		//密码
		Connection connection=null;
		PreparedStatement statement =null;
		ResultSet resultSet=null;
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url,user,pass);
			String sql="insert into test values(?,?,?,?)";
			statement=connection.prepareStatement(sql);
			statement.setString(1, userId);
			statement.setString(2, userName);
			statement.setString(3, sex);
			statement.setString(4, password);
			statement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		session.setAttribute("Id", userId);
		session.setAttribute("userName", userName);
		session.setAttribute("sex",sex);

        //设置3秒钟跳转  
        request.getRequestDispatcher("/work1/success.jsp").forward(request, response);;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
