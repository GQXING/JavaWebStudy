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
			//һ����������ʽ
			//��������и����ַ����������ӿ�������� Class ����
			demo1=Class.forName("com.gqx.Reflect.Demo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		demo2=new Demo().getClass();
		demo3=Demo.class;
		System.out.println("�����ƣ�"+demo1.getName());
		System.out.println("�����ƣ�"+demo2.getName());
		System.out.println("�����ƣ�"+demo3.getName());
		Demo demo=new Demo();
		System.out.println(demo.getClass().getName());
	}

}
