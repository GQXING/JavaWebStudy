package InvokeDemo;

import java.lang.reflect.Method;

public class InvokeTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//ʹ�ø����������������������и����ַ����������ӿ�������� Class ����
		Class<?> c=Class.forName("InvokeDemo.Person");
		//���������person�е�getinfo����
		Method met=c.getMethod("getInFo");
		String val=(String) met.invoke(c.newInstance());
		System.out.println(val);
	}

}
