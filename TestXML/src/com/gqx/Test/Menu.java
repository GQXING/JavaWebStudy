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
			//�����˵�
			printMenu();
			//��ȡ�û�����
			int command=Integer.parseInt(bf.nextLine());
			switch (command) {
			case 1:
				//1�������ϵ��
				Contact contact=new Contact();
				System.out.println("��������ϵ��������");
		
				String name=bf.nextLine();
				contact.setName(name);
				System.out.println("��������ϵ��ID��");
				String id=bf.nextLine();
				contact.setId(id);
				System.out.println("��������ϵ���Ա�");
				String sex=bf.nextLine();
				contact.setSex(sex);
				System.out.println("��������ϵ�����䣺");
				String age=bf.nextLine();
				contact.setAge(age);
				System.out.println("��������ϵ�˵绰��");
				String phone=bf.nextLine();
				contact.setPhone(phone);
				System.out.println("��������ϵ�����䣺");
				String email=bf.nextLine();
				contact.setEmail(email);
				System.out.println("��������ϵ��qq��");
				String qq=bf.nextLine();
				contact.setQq(qq);
				System.out.println(contact);
				operator.addContact(contact);
				break;
			case 2:
				Contact contact1=new  Contact();
				
				System.out.println("������Ҫ�޸ĵ���ϵ��ID��");
				String id1=bf.nextLine();
				contact1.setId(id1);
				System.out.println("�������޸���ϵ��������");
				String name1=bf.nextLine();
				contact1.setName(name1);
				
				System.out.println("�������޸���ϵ���Ա�");
				String sex1=bf.nextLine();
				contact1.setSex(sex1);
				System.out.println("�������޸���ϵ�����䣺");
				String age1=bf.nextLine();
				contact1.setAge(age1);
				System.out.println("�������޸���ϵ�˵绰��");
				String phone1=bf.nextLine();
				contact1.setPhone(phone1);
				System.out.println("�������޸���ϵ�����䣺");
				String email1=bf.nextLine();
				contact1.setEmail(email1);
				System.out.println("�������޸���ϵ��qq��");
				String qq1=bf.nextLine();
				contact1.setQq(qq1);
				operator.ModifyContact(contact1);
				break;
			case 3:
				//ɾ����ϵ��
				String idString=bf.nextLine();
				operator.removeContact(idString);
				operator.removeContact(idString);
				break;
			case 4:
				//�鿴������ϵ��
				List<Contact> contacts=operator.checkContacts();
				for (Contact contact2 : contacts) {
					System.out.println(contact2);
				}
				break;
			case 5:
				System.out.println("�����˳�ϵͳ��");
				System.exit(0);
				
				break;
	
			default:
				System.out.println("����������������룡����");
				break;
			}
		}	
	}
	private static void printMenu() {
		System.out.println("======���˵�======");
		System.out.println("1�������ϵ��");
		System.out.println("2���޸���ϵ��");
		System.out.println("3��ɾ����ϵ��");
		System.out.println("4���鿴������ϵ��");
		System.out.println("5���˳�ϵͳ");
		System.out.println("================");
	}

}
