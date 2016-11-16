package com.gqx.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.gqx.homework.Contact;

public class Menu {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner bf=new Scanner(System.in);
		//
		ContactOperate operator=new Operator();
		while (true) {
			//看到菜单
			printMenu();
			//读取用户输入
			int command=Integer.parseInt(bf.nextLine());
			switch (command) {
			case 1:
				//1、添加联系人
				Contact contact=new Contact();
				System.out.println("请输入联系人姓名：");
		
				String name=bf.nextLine();
				contact.setName(name);
				System.out.println("请输入联系人ID：");
				String id=bf.nextLine();
				contact.setId(id);
				System.out.println("请输入联系人性别：");
				String sex=bf.nextLine();
				contact.setSex(sex);
				System.out.println("请输入联系人年龄：");
				String age=bf.nextLine();
				contact.setAge(age);
				System.out.println("请输入联系人电话：");
				String phone=bf.nextLine();
				contact.setPhone(phone);
				System.out.println("请输入联系人邮箱：");
				String email=bf.nextLine();
				contact.setEmail(email);
				System.out.println("请输入联系人qq：");
				String qq=bf.nextLine();
				contact.setQq(qq);
				System.out.println(contact);
				operator.addContact(contact);
				break;
			case 2:
				Contact contact1=new  Contact();
				
				System.out.println("请输入要修改的联系人ID：");
				String id1=bf.nextLine();
				contact1.setId(id1);
				System.out.println("请输入修改联系人姓名：");
				String name1=bf.nextLine();
				contact1.setName(name1);
				
				System.out.println("请输入修改联系人性别：");
				String sex1=bf.nextLine();
				contact1.setSex(sex1);
				System.out.println("请输入修改联系人年龄：");
				String age1=bf.nextLine();
				contact1.setAge(age1);
				System.out.println("请输入修改联系人电话：");
				String phone1=bf.nextLine();
				contact1.setPhone(phone1);
				System.out.println("请输入修改联系人邮箱：");
				String email1=bf.nextLine();
				contact1.setEmail(email1);
				System.out.println("请输入修改联系人qq：");
				String qq1=bf.nextLine();
				contact1.setQq(qq1);
				operator.ModifyContact(contact1);
				break;
			case 3:
				//删除联系人
				String idString=bf.nextLine();
				operator.removeContact(idString);
				operator.removeContact(idString);
				break;
			case 4:
				//查看所有联系人
				List<Contact> contacts=operator.checkContacts();
				for (Contact contact2 : contacts) {
					System.out.println(contact2);
				}
				break;
			case 5:
				System.out.println("你已退出系统！");
				System.exit(0);
				
				break;
	
			default:
				System.out.println("输入错误，请重新输入！！！");
				break;
			}
		}	
	}
	private static void printMenu() {
		System.out.println("======主菜单======");
		System.out.println("1、添加联系人");
		System.out.println("2、修改联系人");
		System.out.println("3、删除联系人");
		System.out.println("4、查看所有联系人");
		System.out.println("5、退出系统");
		System.out.println("================");
	}

}
