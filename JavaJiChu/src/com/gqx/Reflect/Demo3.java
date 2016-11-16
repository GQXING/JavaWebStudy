package com.gqx.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Demo3 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		// TODO Auto-generated method stub
		//获取类的Class对象
		Class<?> demo1=Class.forName("com.gqx.Reflect.Person");
		Class<?> demo2=new Person().getClass();
		Class<?> demo3=Person.class;
		
		
		/**
		 * 获取Field
		 */

		// 使用getFields获取属性(公共字段的 Field 对象的数组)  
		Field[] fields = demo1.getFields();  
		for (Field f : fields)  
		{  
		    System.out.println(f);  
		} 
		// 使用getDeclaredFields获取属性  
		fields = demo1.getDeclaredFields();  
		for (Field f : fields)  
		{  
		    System.out.println(f);  
		} 
		
		
		/**
		 * 获取类的Method
		 */
		System.out.println("===============类的全部方法===============");
		//返回一个包含某些 Method 对象的数组，这些对象反映此 Class 对象所表示的类或接口
		//（包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的公共 member 方法。
		Method[] method = demo1.getMethods();  
		for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int temp = method[i].getModifiers();
            //取得修饰符
            System.out.print(Modifier.toString(temp) + " ");
            //取得返回类型
            System.out.print(returnType.getName() + "  ");
            //取得方法名称
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            //取得c参数
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
            //是否存在异常
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
		 * 获取类的Constructor
		 */
		System.out.println("*****************");
		// 使用getDeclaredConstructors获取构造器   
		//返回一个包含某些 Constructor 对象的数组，这些对象反映此 Class 对象所表示的类的所有公共构造方法。
		Constructor<?>[] constructors = demo1.getConstructors();  
		for (Constructor<?> m : constructors)  
		{  
		    System.out.println(m);  
		}
		// 使用getDeclaredConstructors获取构造器     
		constructors = demo1.getDeclaredConstructors();  
		for (Constructor<?> m : constructors)  
		{  
		    System.out.println(m);  
		}       
		
		/**
		 * 新建类的实例
		 */
		
		System.out.println("*****************");
		//想调用方法，必须去获得method方法
		/**
		 * getMethod(String name, Class<?>... parameterTypes) 
          *返回一个 Method 对象，它反映此 Class 对象所表示的类或接口的指定公共成员方法。
          *String：方法的名字，
          *Class<?>... parameterTypes：该方法需要接受的参数，数组的形式，
          *因为java中的方法会根据参数个数容易出现重载。
		 */
		Object demo=demo3.newInstance();
		Method addMethod=demo3.getMethod("add",new Class[ ]{int.class,int.class} );
		Object result=addMethod.invoke(demo, new Object[]{1,2});
		System.out.println((Integer)result);
		
		/**
		 * 获取某个类的全部属性
		 */
		System.out.println("===============本类属性===============");
		Field[] field = demo1.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
        }
        
        System.out.println("==========私有的属性==========");
        // 取得实现的接口或者父类的属性
        Field[] filed1 = demo1.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
    } 
}
	
	

}
