package com.gqx.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("[1]添加联系人");
		System.out.println("[2]修改联系人");
		
		String index=buff.readLine();
		System.out.println(index);
		switch (index) {
		case "1":
			Contact contact=new Contact();
			System.out.println("编号");
			String id=buff.readLine();
			contact.setId(id);
			System.out.println("姓名");
			String name=buff.readLine();
			contact.setName(name);
			System.out.println("性别");
			String sex=buff.readLine();
			contact.setSex(sex);
			System.out.println("年龄");
			String age=buff.readLine();
			contact.setAge(age);
			System.out.println("电话");
			String phone=buff.readLine();
			contact.setPhone(name);
			System.out.println("QQ");
			String qq=buff.readLine();
			contact.setQq(qq);
			System.out.println("邮箱");
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
