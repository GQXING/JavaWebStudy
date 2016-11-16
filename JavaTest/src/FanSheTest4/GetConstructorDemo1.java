package FanSheTest4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class GetConstructorDemo1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class<?> c=Class.forName("FanSheTest4.Person");
		Constructor<?> constructor[]= c.getConstructors(); //得到全部的构造方法
		for (int i = 0; i < constructor.length; i++) {
			int mod=constructor[i].getModifiers();  //得到修饰符
			String string=Modifier.toString(mod);	//还原权限
			Class<?> param[]=constructor[i].getParameterTypes(); //得到全部的参数
			System.out.print(string+"  "); //输出内容
			System.out.print(constructor[i].getName()+"(");
			for (int x = 0; x < param.length; x++) {
				System.out.print(param[x].getName()+"arg-"+x);
				if (x<param.length-1) {
					System.out.print(",");				
				}	
			}
			System.out.println(")");
		}
	}
}
