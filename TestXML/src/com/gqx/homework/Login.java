package com.gqx.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("[1]�����ϵ��");
		System.out.println("[2]�޸���ϵ��");
		
		String index=buff.readLine();
		System.out.println(index);
		switch (index) {
		case "1":
			Contact contact=new Contact();
			System.out.println("���");
			String id=buff.readLine();
			contact.setId(id);
			System.out.println("����");
			String name=buff.readLine();
			contact.setName(name);
			System.out.println("�Ա�");
			String sex=buff.readLine();
			contact.setSex(sex);
			System.out.println("����");
			String age=buff.readLine();
			contact.setAge(age);
			System.out.println("�绰");
			String phone=buff.readLine();
			contact.setPhone(name);
			System.out.println("QQ");
			String qq=buff.readLine();
			contact.setQq(qq);
			System.out.println("����");
			String email=buff.readLine();
			contact.setEmail(email);
			new SAXRTest().addContract(contact);
			break;
			
		case "2":
			new SAXRTest().Show();
			break;
		default:
			break;
		}
		
		
	}
	
}
