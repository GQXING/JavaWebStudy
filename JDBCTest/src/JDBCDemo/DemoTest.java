package JDBCDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoTest {
	private static Connection connection=null;
	private static PreparedStatement pstStatement=null;
	private static ResultSet rst=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//����JDBC������DBManager��getCon()��ȡConnection����
			connection=Demo.getConnection();
			pstStatement=connection.prepareStatement("select * from Stu where UserSex=?");
			//�����Ա�Ϊ�еĶ���
			pstStatement.setString(1, "��");
			//ִ�����
			rst=pstStatement.executeQuery();
			while (rst.next()) {
				String name=rst.getString("UserName");
				String sex=rst.getString("userSex");
				System.out.println("������"+name+"\t�Ա�"+sex);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//����JDBC������DBManager����ط����ر���Դ
		finally{
			Demo.closeResult(rst);
			Demo.CloseStateMent(pstStatement);
			Demo.closeConnection(connection);
		}
	}
}
