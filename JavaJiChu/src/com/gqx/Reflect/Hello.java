package com.gqx.Reflect;
class Demo{
	
}
public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class<?> demo1=null;
		Class<?> demo2=null;
		Class<?> demo3=null;
		
		try {
			//一般采用这个格式
			//返回与带有给定字符串名的类或接口相关联的 Class 对象。
			demo1=Class.forName("com.gqx.Reflect.Demo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		demo2=new Demo().getClass();
		demo3=Demo.class;
		System.out.println("类名称："+demo1.getName());
		System.out.println("类名称："+demo2.getName());
		System.out.println("类名称："+demo3.getName());
		Demo demo=new Demo();
		System.out.println(demo.getClass().getName());
	}

}
