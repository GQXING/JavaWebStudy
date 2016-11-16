package com.gqx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ���Ͷ�
 * @author Administrator
 *
 */
public class ContextDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�õ������
		ServletContext context=this.getServletContext();
		//�ѱ�������ݷŵ��������
		context.setAttribute("student", new Student("gqx",21));
		System.out.println("����ɹ���");
		
		//context.setAttribute("user", "gqxing");
	}

}

class Student{
	private String nameString;
	private int age;
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(String nameString,int age){
		this.nameString=nameString;
		this.age=age;
	}
	@Override
	public String toString() {
		return "Student [nameString=" + nameString + ", age=" + age + "]";
	}
	
}
