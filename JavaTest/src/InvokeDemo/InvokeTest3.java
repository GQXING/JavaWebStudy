package InvokeDemo;

import java.lang.reflect.Method;

public class InvokeTest3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//ʹ�ø����������������������и����ַ����������ӿ�������� Class ����
		Class<?> c=Class.forName("InvokeDemo.Person");
	
		Object object=c.newInstance();
		set("name", "MLDN", object,String.class);
		
		get("name", object);
		set("age", 30, object,int.class);
		get("age", object);
		System.out.println(object);
	}

	
	public static void set(String name,Object value,Object obj,Class<?> type) throws Exception{
		Method method=obj.getClass().getMethod("set"+initStr(name),type);
		method.invoke(obj, value);	//���÷���
	}
	
	public static void get(String nameString,Object object)throws Exception{
		Method method=object.getClass().getMethod("get"+initStr(nameString));
		Object value=method.invoke(object);
		System.out.println(value);
	}
	
	//����ĸת��Ϊ��д
	public static StringBuffer initStr(String name){
		StringBuffer buffer=new StringBuffer();
		buffer.append(name.substring(0,1).toUpperCase()).append(name.substring(1));
		return buffer;
	}
	

}
