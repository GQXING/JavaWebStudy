package com.gqx.test2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo4 extends HttpServlet {

	/**
	 * ��ͼƬд���������
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpg");
		/**
		 * ���������صķ�ʽ���ļ�
		 */
		File file=new File("F:/4.jpg");
		response.setHeader("Content-Disposition", "attachment;filename="+file.getName());
		FileInputStream in=new FileInputStream(file);
		byte[] buf=new byte[1024];
		int len=0;
		//��ʼд
		while ((len=in.read(buf))!=-1) {
			response.getOutputStream().write(buf,0,len);
		}
		
	}

}
