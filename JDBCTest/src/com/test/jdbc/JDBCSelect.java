package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCSelect {
	
	//ʹ����reparedstatement
	  private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	  private static String url="jdbc:sqlserver://localhost:1433;DatabaseName=test";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement pst=null;
		try {
			//��������
			Class.forName(driver);
			System.out.println("�������سɹ�");
			try {
				connection=DriverManager.getConnection(url,"sa","123456");
				System.out.println("���ݿ����ӳɹ���");
				pst=connection.prepareStatement("insert into Stu(UserName,UserSex) values(?,?)");
				pst.setString(1, "����");
				pst.setString(2, "Ů");
				//��PreparedStatement������ִ��SQL���
				pst.execute();
				System.out.println("���ݲ���ɹ���");
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
