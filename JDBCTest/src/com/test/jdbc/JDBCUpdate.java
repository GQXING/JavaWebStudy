package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUpdate {
	  private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	  private static String url="jdbc:sqlserver://localhost:1433;DatabaseName=test";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstStatement=null;
		try {
			Class.forName(driver);
			System.out.println("�������سɹ�");
			con=DriverManager.getConnection(url,"sa","123456");
			System.out.println("���ݿ����Ӵ�");
			//��idΪ2���������ָ�Ϊ����
			pstStatement=con.prepareStatement("update Stu set UserName=? where UserId=?");
			pstStatement.setString(1, "���ĺ�");
			pstStatement.setInt(2, 2);
			//��preparestatement��ִ��
			if (pstStatement.executeUpdate()>0) {
				System.out.println("���ݿ��޸ĳɹ���");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				pstStatement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
