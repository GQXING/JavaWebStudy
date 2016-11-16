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
			Class.forName(driver);	//��������
			System.out.println("�������سɹ���");
			try {
				con=DriverManager.getConnection(url,"sa","123456");
				System.out.println("���ݿ����ӳɹ�!");
				pStatement=con.prepareStatement("select * from Stu");
				//ִ��prepareStatement���
				ResultSet result=pStatement.executeQuery();
				//�����¼ָ���ƶ�֮����Ȼָ����Ч�У���next��������true
				while (result.next()) {
					String name=result.getString(2);	  //������������ȡ���
					String sex=result.getString("UserSex");	//���������ַ�����ý��
					System.out.println("������"+name+"\t �Ա�"+sex);
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
