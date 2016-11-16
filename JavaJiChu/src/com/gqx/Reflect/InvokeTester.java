package com.gqx.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeTester {
	public int add(int para1,int para2){
		return para1+para2;
	}
	public String echo(String message){
		return "hello："+message;
	}
	public static void main(String args[]) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		//		InvokeTester test=new InvokeTester();
		//		System.out.println(test.add(1, 2));
		//		System.out.println(test.echo("gqx"));
		
		//通过反射
		//首先要获取class对象
		Class<?> classType=InvokeTester.class;//获取该类
		//Class：newInstance()创建此 Class 对象所表示的类的一个新实例。
		Object invokeTester=classType.newInstance();
		//System.out.println(invokeTester instanceof InvokeTester);
		
		//想调用方法，必须去获得method方法
		/**
		 * getMethod(String name, Class<?>... parameterTypes) 
          *返回一个 Method 对象，它反映此 Class 对象所表示的类或接口的指定公共成员方法。
          *String：方法的名字，
          *Class<?>... parameterTypes：该方法需要接受的参数，数组的形式，
          *因为java中的方法会根据参数个数容易出现重载。
		 */
		Method addMethod=classType.getMethod("add",new Class[ ]{int.class,int.class} );
		Object result=addMethod.invoke(invokeTester, new Object[]{1,2});
		System.out.println((Integer)result);
		
	
	}
}
