package com.gqxing.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.gqxing.dao.Operate;
import com.gqxing.entity.Student;

public class Menu {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Operate operate=new Operate();
		BufferedReader in = 
				new BufferedReader(new InputStreamReader(System.in));
		//进入菜单部分
		while (true) {
			//显现菜单
			System.out.println("/*********************************************************/");
			System.out.println("1、添加到本地学生列表（student.xml）");
			System.out.println("2、查看本地所有学生的列表信息（student.xml）");
			System.out.println("3、删除指定ID学生的列表信息（student.xml）");
			System.out.println("4、退出该查询和添加服务系统");
			System.out.println("/*********************************************************/");
			
			int select=Integer.parseInt(in.readLine());
			switch (select) {
			case 1:
				//将学生添加到本地xml文件
				Student student=new Student();
				System.out.println("请输入学生的姓名：");
				String name=in.readLine();
				student.setName(name);
				System.out.println("请输入学生的ID：");
				String id=in.readLine();
				student.setID(id);
				System.out.println("请输入学生的班级：");
				String classString=in.readLine();
				student.setClassString(classString);
				System.out.println("请输入学生的性别：");
				String sex=in.readLine();
				student.setSex(sex);
				System.out.println("请输入学生的出生年月日");
				String birth=in.readLine();
				student.setBirth(birth);
				System.out.println("请输入学生户籍所在地：");
				String city=in.readLine();
				student.setCity(city);
				System.out.println("请输入学生的手机号码：");
				String mobile=in.readLine();
				student.setMonile(mobile);
				operate.addStudent(student);
				
				break;
			case 2:
				List<Student> students=operate.getStudents();
				for (Student s : students) {
					System.out.println(s);
				}
				break;
			case 3:
				System.out.println("请输入你要删除的联系人ID：");
				String idString=in.readLine();
				operate.remove(idString);
			
			case 4:
				System.out.println("您已退出本系统！");
				System.exit(0);
				break;
			default:
				System.out.println(in);
				System.out.println("抱歉，您的输入有问题请重新输入！");
				break;
			}
		}
		
		
	}

}
