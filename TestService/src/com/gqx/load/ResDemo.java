package com.gqx.load;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 读取web应用下面的资源文件（例如propertis)
 * @author Administrator
 *
 */
public class ResDemo extends HttpServlet {
	/**
	 *   "."  相对于java命令运行的当前路径
	 *   在java项目中，“.”代表java目录的根目录下开始，
	 *   在web项目中："."代表当前在tomcat/bin目录下开始，所以不能使用这种相对路径
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 得到web应用资源下的文件
		//方法1、servletContxt中的方法，拿到项目下的文件
//		String path=this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
//		File file=new File(path);
//		System.out.println(file.getAbsolutePath());
//		
//		FileInputStream in=new FileInputStream(file);
		
		
		//方法2、getResourceAsStream() 	得到资源文件，返回输入流
		InputStream in=this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
			Properties pro=new Properties();
			//读取资源文件
			pro.load(in);
			
			String user=pro.getProperty("user");
			String password=pro.getProperty("password");
			System.out.println("user="+user);
			System.out.println("password="+password);
	}
}
