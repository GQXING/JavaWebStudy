package com.gqx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 发送端
 * @author Administrator
 *
 */
public class ContextDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到域对象
		ServletContext context=this.getServletContext();
		//把保存的数据放到域对象中
		context.setAttribute("student", new Student("gqx",21));
		System.out.println("保存成功！");
		
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
