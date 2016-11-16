package com.gqxing.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gqxing.dao.Operate;
import com.gqxing.entity.Student;
/**
 * 此包用于调试各种类的方法
 * @author Administrator
 *
 */
public class TestDemo {


		Operate operate=null;
		@Before
		public void init(){
			 operate= new Operate();
		}
		
		@Test
		public void addStudent() throws Exception{
			Student student=new Student();
			student.setID("001");
			student.setClassString("软工一班");
			student.setName("张三");
			student.setSex("男");
			student.setBirth("1995-6-13");
			student.setCity("黄石");
			student.setMonile("13545642616");
			
			operate.addStudent(student);
		}
		
		@Test
		public void Showall()
		{
			List<Student> students=operate.getStudents();
			for (Student student : students) {
				System.out.println(student);
			}
		}
		
		@Test
		public void remove() throws Exception
		{
			operate.remove("1");
		}


}
