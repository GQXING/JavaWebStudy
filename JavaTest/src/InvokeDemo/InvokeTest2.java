package InvokeDemo;

import java.lang.reflect.Method;

public class InvokeTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//使用给定的类加载器，返回与带有给定字符串名的类或接口相关联的 Class 对象。
		Class<?> c=Class.forName("InvokeDemo.Person");
		//本程序调用person中的getinfo方法
		Method met=c.getMethod("getInFo");
		String val=(String) met.invoke(c.newInstance());
		System.out.println(val);
	}

}
