package com.gqxing.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gqxing.dao.Operate;
import com.gqxing.entity.Student;
/**
 * �˰����ڵ��Ը�����ķ���
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
			student.setClassString("��һ��");
			student.setName("����");
			student.setSex("��");
			student.setBirth("1995-6-13");
			student.setCity("��ʯ");
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
