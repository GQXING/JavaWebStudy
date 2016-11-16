package JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String driver=
				"com.microsoft.sqlserver.jdbc.SQLServerDriver";
		final String url=
				"jdbc:sqlserver://localhost:1433;DataBaseName=教学库";
		final String user="sa";			//数据库管理员名
		final String pass="123456";		//密码
		Connection connection=null;
		PreparedStatement statement =null;
		ResultSet resultSet=null;
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url,user,pass);
			String sql="select * from test where Id= ?  and password=?";
			statement=connection.prepareStatement(sql);
			statement.setString(1, "201404582");
			statement.setString(2, "123456");
			resultSet=statement.executeQuery();
			if (resultSet.next()) {
					int count=resultSet.getInt(1);
				
				if (count>0) {
					System.out.println("Hello,,,");
				}else {
				System.out.println("Sorry....");
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (statement != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (connection != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
