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
		//����˵�����
		while (true) {
			//���ֲ˵�
			System.out.println("/*********************************************************/");
			System.out.println("1����ӵ�����ѧ���б�student.xml��");
			System.out.println("2���鿴��������ѧ�����б���Ϣ��student.xml��");
			System.out.println("3��ɾ��ָ��IDѧ�����б���Ϣ��student.xml��");
			System.out.println("4���˳��ò�ѯ����ӷ���ϵͳ");
			System.out.println("/*********************************************************/");
			
			int select=Integer.parseInt(in.readLine());
			switch (select) {
			case 1:
				//��ѧ����ӵ�����xml�ļ�
				Student student=new Student();
				System.out.println("������ѧ����������");
				String name=in.readLine();
				student.setName(name);
				System.out.println("������ѧ����ID��");
				String id=in.readLine();
				student.setID(id);
				System.out.println("������ѧ���İ༶��");
				String classString=in.readLine();
				student.setClassString(classString);
				System.out.println("������ѧ�����Ա�");
				String sex=in.readLine();
				student.setSex(sex);
				System.out.println("������ѧ���ĳ���������");
				String birth=in.readLine();
				student.setBirth(birth);
				System.out.println("������ѧ���������ڵأ�");
				String city=in.readLine();
				student.setCity(city);
				System.out.println("������ѧ�����ֻ����룺");
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
				System.out.println("��������Ҫɾ������ϵ��ID��");
				String idString=in.readLine();
				operate.remove(idString);
			
			case 4:
				System.out.println("�����˳���ϵͳ��");
				System.exit(0);
				break;
			default:
				System.out.println(in);
				System.out.println("��Ǹ�������������������������룡");
				break;
			}
		}
		
		
	}

}
