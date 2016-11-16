package JDBCDemo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {
	private static final String driver=
			"com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url=
			"jdbc:sqlserver://localhost:1433;DataBaseName=test";
	
	private static final String user="sa";			//用户名
	private static final String password="123456";		//密码
	private static Connection con=null;
	
	//获取数据库连接
	public static Connection getConnection(){
		try {
			//加载驱动
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	//关闭数据库连接
	public static void closeConnection(Connection con){
		try {
					if (con!=null) {
					con.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		}
	
	//关闭ResultSet
	public static void closeResult(ResultSet rst){
		try {
			if (rst!=null) {
				rst.close();
				rst=null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//关闭StateMent
	public static void CloseStateMent(PreparedStatement pst){
		try {
			if (pst!=null) {
				pst.close();
				pst=null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}

