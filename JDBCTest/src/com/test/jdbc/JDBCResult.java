package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCResult {
	  private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	  private static String url="jdbc:sqlserver://localhost:1433;DatabaseName=test";
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pStatement=null;
		
		try {
			Class.forName(driver);	//加载驱动
			System.out.println("驱动加载成功！");
			try {
				con=DriverManager.getConnection(url,"sa","123456");
				System.out.println("数据库连接成功!");
				pStatement=con.prepareStatement("select * from Stu");
				//执行prepareStatement语句
				ResultSet result=pStatement.executeQuery();
				//如果记录指针移动之后仍然指向有效行，则next方法返回true
				while (result.next()) {
					String name=result.getString(2);	  //根据列索引获取结果
					String sex=result.getString("UserSex");	//根据列名字符串获得结果
					System.out.println("姓名："+name+"\t 性别："+sex);
				}
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
				pStatement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
