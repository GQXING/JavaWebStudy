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
 * ��ȡwebӦ���������Դ�ļ�������propertis)
 * @author Administrator
 *
 */
public class ResDemo extends HttpServlet {
	/**
	 *   "."  �����java�������еĵ�ǰ·��
	 *   ��java��Ŀ�У���.������javaĿ¼�ĸ�Ŀ¼�¿�ʼ��
	 *   ��web��Ŀ�У�"."����ǰ��tomcat/binĿ¼�¿�ʼ�����Բ���ʹ���������·��
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �õ�webӦ����Դ�µ��ļ�
		//����1��servletContxt�еķ������õ���Ŀ�µ��ļ�
//		String path=this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
//		File file=new File(path);
//		System.out.println(file.getAbsolutePath());
//		
//		FileInputStream in=new FileInputStream(file);
		
		
		//����2��getResourceAsStream() 	�õ���Դ�ļ�������������
		InputStream in=this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
			Properties pro=new Properties();
			//��ȡ��Դ�ļ�
			pro.load(in);
			
			String user=pro.getProperty("user");
			String password=pro.getProperty("password");
			System.out.println("user="+user);
			System.out.println("password="+password);
	}
}
