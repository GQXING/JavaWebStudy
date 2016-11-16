package com.gqx.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeTester {
	public int add(int para1,int para2){
		return para1+para2;
	}
	public String echo(String message){
		return "hello��"+message;
	}
	public static void main(String args[]) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		//		InvokeTester test=new InvokeTester();
		//		System.out.println(test.add(1, 2));
		//		System.out.println(test.echo("gqx"));
		
		//ͨ������
		//����Ҫ��ȡclass����
		Class<?> classType=InvokeTester.class;//��ȡ����
		//Class��newInstance()������ Class ��������ʾ�����һ����ʵ����
		Object invokeTester=classType.newInstance();
		//System.out.println(invokeTester instanceof InvokeTester);
		
		//����÷���������ȥ���method����
		/**
		 * getMethod(String name, Class<?>... parameterTypes) 
          *����һ�� Method ��������ӳ�� Class ��������ʾ�����ӿڵ�ָ��������Ա������
          *String�����������֣�
          *Class<?>... parameterTypes���÷�����Ҫ���ܵĲ������������ʽ��
          *��Ϊjava�еķ�������ݲ����������׳������ء�
		 */
		Method addMethod=classType.getMethod("add",new Class[ ]{int.class,int.class} );
		Object result=addMethod.invoke(invokeTester, new Object[]{1,2});
		System.out.println((Integer)result);
		
	
	}
}
