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
			//调用JDBC公共类DBManager的getCon()获取Connection对象；
			connection=Demo.getConnection();
			pstStatement=connection.prepareStatement("select * from Stu where UserSex=?");
			//查找性别为男的对象
			pstStatement.setString(1, "男");
			//执行语句
			rst=pstStatement.executeQuery();
			while (rst.next()) {
				String name=rst.getString("UserName");
				String sex=rst.getString("userSex");
				System.out.println("姓名："+name+"\t性别："+sex);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//调用JDBC公共类DBManager的相关方法关闭资源
		finally{
			Demo.closeResult(rst);
			Demo.CloseStateMent(pstStatement);
			Demo.closeConnection(connection);
		}
	}
}
