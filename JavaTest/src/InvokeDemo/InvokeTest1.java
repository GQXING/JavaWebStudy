package InvokeDemo;

import java.lang.reflect.Method;

public class InvokeTest1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class<?> c=Class.forName("InvokeDemo.Person");
		//�������н�����Person���е�Hello����
		// ����һ������ĳЩ Method ��������飬
		//��Щ����ӳ�� Class ������������ӿڣ�������Щ�ɸ����ӿ��������Լ��ӳ���ͳ��ӿڼ̳е���Щ�����ӿڣ�
		//�Ĺ��� member ������  
		Method met=c.getMethod("sayHello");
		//�Դ���ָ��������ָ����������ɴ� Method �����ʾ�ĵײ㷽����
		met.invoke(c.newInstance());
	}

}
