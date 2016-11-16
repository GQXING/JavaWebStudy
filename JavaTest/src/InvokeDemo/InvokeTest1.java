package InvokeDemo;

import java.lang.reflect.Method;

public class InvokeTest1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class<?> c=Class.forName("InvokeDemo.Person");
		//本程序中将调用Person类中的Hello方法
		// 返回一个包含某些 Method 对象的数组，
		//这些对象反映此 Class 对象所表的类或接口（包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）
		//的公共 member 方法。  
		Method met=c.getMethod("sayHello");
		//对带有指定参数的指定对象调用由此 Method 对象表示的底层方法。
		met.invoke(c.newInstance());
	}

}
