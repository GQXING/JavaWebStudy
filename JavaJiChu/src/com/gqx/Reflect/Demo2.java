package com.gqx.Reflect;

import java.lang.reflect.Method;

public class Demo2 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//Ҫ����ĳ���࣬�ͱ���Ҫ֪��������ȫ��
		//  ��������и����ַ����������ӿ�������� Class ����
		Class<?> classType=Class.forName("java.lang.String");
		/**
		 * ���� Method �����һ�����飬
		 * ��Щ����ӳ�� Class �����ʾ�����ӿ����������з�����
		 * ����������������Ĭ�ϣ��������ʺ�˽�з��������������̳еķ���
		 */
		Method[] methods=classType.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		
	}

}
