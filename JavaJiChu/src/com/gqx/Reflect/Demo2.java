package com.gqx.Reflect;

import java.lang.reflect.Method;

public class Demo2 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//要操纵某个类，就必须要知道这个类的全称
		//  返回与带有给定字符串名的类或接口相关联的 Class 对象。
		Class<?> classType=Class.forName("java.lang.String");
		/**
		 * 返回 Method 对象的一个数组，
		 * 这些对象反映此 Class 对象表示的类或接口声明的所有方法，
		 * 包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法
		 */
		Method[] methods=classType.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		
	}

}
