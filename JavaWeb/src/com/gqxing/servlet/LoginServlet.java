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

public class LoginServlet extends HttpServlet {

	/**
	 * 处理登入验证
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//获取参数
		String id=request.getParameter("userId");
		String password=request.getParameter("password");
		
		//连接数据库在数据库中去查询
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
			String sql="select * from test where Id= ?  and password=?";
			statement=connection.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, password);
			resultSet=statement.executeQuery();
			if (resultSet.next()) {
					HttpSession session=request.getSession();
					session.setAttribute("Id", resultSet.getString("Id"));
					session.setAttribute("userName", resultSet.getString("name"));
					session.setAttribute("sex", resultSet.getString("sex"));
					response.sendRedirect(request.getContextPath()+"/work1/user.jsp");
			}else {
				response.getWriter().write("<p style='color:red'>你的用户名或密码错误，请问你是否要<a href='"+request.getContextPath()+"/work1/login.html'>返回登入</a>");
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
