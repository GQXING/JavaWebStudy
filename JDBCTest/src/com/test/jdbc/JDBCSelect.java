package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCSelect {
	
	//使用批reparedstatement
	  private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	  private static String url="jdbc:sqlserver://localhost:1433;DatabaseName=test";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement pst=null;
		try {
			//加载驱动
			Class.forName(driver);
			System.out.println("驱动加载成功");
			try {
				connection=DriverManager.getConnection(url,"sa","123456");
				System.out.println("数据库连接成功！");
				pst=connection.prepareStatement("insert into Stu(UserName,UserSex) values(?,?)");
				pst.setString(1, "张三");
				pst.setString(2, "女");
				//在PreparedStatement对象中执行SQL语句
				pst.execute();
				System.out.println("数据插入成功！");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			try {
				pst.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}

}
