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
		  java.sql.Statement stat=null;		//����statement����
		  try
		  {
			  //��������
		   Class.forName(driverName);
		   //�������ݿ�
		   dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		   System.out.println(dbConn);
		    System.out.println("�������ݿ�ɹ�");
		   stat=dbConn.createStatement();   //��ʼ��statement����
		   String sqlString="insert into Stu(UserName,UserSex) values('������','��')";
		   //ִ�в������
		   //int executeUpdate(String sql)����ִ��Insert ��Updata��delete��䣬�Լ�sql ddl��䣻
		   int num=stat.executeUpdate(sqlString); 	
		   if (num>0) {
			System.out.println("���ݲ���ɹ���");
		}
		   
		   dbConn.close(); 				//���ݿ�ʹ����֮�󣬹ر���Դ
		    
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   System.out.print("����ʧ��");
		  }    
	}

}
