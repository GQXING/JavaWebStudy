package FanSheTest4;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GetAllWay {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//使用给定的类加载器，返回与带有给定字符串名的类或接口相关联的 Class 对象。
		Class<?> c=Class.forName("FanSheTest4.Person");
		Method m[]=c.getMethods(); //取得全部的方法
		for (int i = 0; i < m.length; i++) {
			String mod=Modifier.toString(m[i].getModifiers()); //取得访问权限
			String metName=m[i].getName();	//取得方法名称
			Class<?> ret =m[i].getReturnType();	//获取返回值类型
			Class<?> param[]=m[i].getParameterTypes();	//取得全部的参数类型
			Class<?> exc[] = m[i].getExceptionTypes();	//取得全部的异常
			System.out.print(mod +" ");
			System.out.print(ret+" ");
			System.out.print(metName+"(");
			for (int x = 0; x < param.length; x++) {
				System.out.print(param[x]);
				if (x<param.length-1) {
					System.out.print(",");
				}
			}
			System.out.print(")");
			
			//有异常的抛出异常
			if (exc.length>0) {
				System.out.print(" throws");
				for (int j = 0; j < exc.length;j++) {
					System.out.println(exc[j].getName());
					if (j<exc.length-1) {
						System.out.println(",");
					}
				}
			}
			System.out.println();
		}
	}

}
