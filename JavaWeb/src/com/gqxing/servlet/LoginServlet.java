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
	 * ���������֤
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//��ȡ����
		String id=request.getParameter("userId");
		String password=request.getParameter("password");
		
		//�������ݿ������ݿ���ȥ��ѯ
		final String driver=
				"com.microsoft.sqlserver.jdbc.SQLServerDriver";
		final String url=
				"jdbc:sqlserver://localhost:1433;DataBaseName=��ѧ��";
		final String user="sa";			//���ݿ����Ա��
		final String pass="123456";		//����
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
				response.getWriter().write("<p style='color:red'>����û�������������������Ƿ�Ҫ<a href='"+request.getContextPath()+"/work1/login.html'>���ص���</a>");
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
