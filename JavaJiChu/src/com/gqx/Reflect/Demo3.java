package com.gqx.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Demo3 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		// TODO Auto-generated method stub
		//��ȡ���Class����
		Class<?> demo1=Class.forName("com.gqx.Reflect.Person");
		Class<?> demo2=new Person().getClass();
		Class<?> demo3=Person.class;
		
		
		/**
		 * ��ȡField
		 */

		// ʹ��getFields��ȡ����(�����ֶε� Field ���������)  
		Field[] fields = demo1.getFields();  
		for (Field f : fields)  
		{  
		    System.out.println(f);  
		} 
		// ʹ��getDeclaredFields��ȡ����  
		fields = demo1.getDeclaredFields();  
		for (Field f : fields)  
		{  
		    System.out.println(f);  
		} 
		
		
		/**
		 * ��ȡ���Method
		 */
		System.out.println("===============���ȫ������===============");
		//����һ������ĳЩ Method ��������飬��Щ����ӳ�� Class ��������ʾ�����ӿ�
		//��������Щ�ɸ����ӿ��������Լ��ӳ���ͳ��ӿڼ̳е���Щ�����ӿڣ��Ĺ��� member ������
		Method[] method = demo1.getMethods();  
		for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int temp = method[i].getModifiers();
            //ȡ�����η�
            System.out.print(Modifier.toString(temp) + " ");
            //ȡ�÷�������
            System.out.print(returnType.getName() + "  ");
            //ȡ�÷�������
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            //ȡ��c����
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
            //�Ƿ�����쳣
            Class<?> exce[] = method[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }
		
		System.out.println();  
		   
		
		/**
		 * ��ȡ���Constructor
		 */
		System.out.println("*****************");
		// ʹ��getDeclaredConstructors��ȡ������   
		//����һ������ĳЩ Constructor ��������飬��Щ����ӳ�� Class ��������ʾ��������й������췽����
		Constructor<?>[] constructors = demo1.getConstructors();  
		for (Constructor<?> m : constructors)  
		{  
		    System.out.println(m);  
		}
		// ʹ��getDeclaredConstructors��ȡ������     
		constructors = demo1.getDeclaredConstructors();  
		for (Constructor<?> m : constructors)  
		{  
		    System.out.println(m);  
		}       
		
		/**
		 * �½����ʵ��
		 */
		
		System.out.println("*****************");
		//����÷���������ȥ���method����
		/**
		 * getMethod(String name, Class<?>... parameterTypes) 
          *����һ�� Method ��������ӳ�� Class ��������ʾ�����ӿڵ�ָ��������Ա������
          *String�����������֣�
          *Class<?>... parameterTypes���÷�����Ҫ���ܵĲ������������ʽ��
          *��Ϊjava�еķ�������ݲ����������׳������ء�
		 */
		Object demo=demo3.newInstance();
		Method addMethod=demo3.getMethod("add",new Class[ ]{int.class,int.class} );
		Object result=addMethod.invoke(demo, new Object[]{1,2});
		System.out.println((Integer)result);
		
		/**
		 * ��ȡĳ�����ȫ������
		 */
		System.out.println("===============��������===============");
		Field[] field = demo1.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // Ȩ�����η�
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // ��������
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
        }
        
        System.out.println("==========˽�е�����==========");
        // ȡ��ʵ�ֵĽӿڻ��߸��������
        Field[] filed1 = demo1.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // Ȩ�����η�
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // ��������
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
    } 
}
	
	

}
