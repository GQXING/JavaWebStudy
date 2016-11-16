package com.test.jdbc;
import static org.junit.Assert.*;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
public class JDBCDemo {
	@Test
	public void testDemo() throws Exception {
		 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=test";
		  String userName="sa";
		  String userPwd="123456";
		  Connection dbConn=null;
		  java.sql.Statement stat=null;		//声明statement对象
		  try
		  {
			  //加载驱动
		   Class.forName(driverName);
		   //链接数据库
		   dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		   System.out.println(dbConn);
		    System.out.println("连接数据库成功");
		   stat=dbConn.createStatement();   //初始化statement对象
		   String sqlString="insert into Stu(UserName,UserSex) values('郭庆兴','男')";
		   //执行插入语句
		   //int executeUpdate(String sql)用于执行Insert 、Updata或delete语句，以及sql ddl语句；
		   int num=stat.executeUpdate(sqlString); 	
		   if (num>0) {
			System.out.println("数据插入成功！");
		}
		   
		   dbConn.close(); 				//数据库使用完之后，关闭资源
		    
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   System.out.print("连接失败");
		  }    
	}

}
