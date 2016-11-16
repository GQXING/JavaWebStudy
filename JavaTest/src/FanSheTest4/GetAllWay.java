package FanSheTest4;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GetAllWay {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//ʹ�ø����������������������и����ַ����������ӿ�������� Class ����
		Class<?> c=Class.forName("FanSheTest4.Person");
		Method m[]=c.getMethods(); //ȡ��ȫ���ķ���
		for (int i = 0; i < m.length; i++) {
			String mod=Modifier.toString(m[i].getModifiers()); //ȡ�÷���Ȩ��
			String metName=m[i].getName();	//ȡ�÷�������
			Class<?> ret =m[i].getReturnType();	//��ȡ����ֵ����
			Class<?> param[]=m[i].getParameterTypes();	//ȡ��ȫ���Ĳ�������
			Class<?> exc[] = m[i].getExceptionTypes();	//ȡ��ȫ�����쳣
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
			
			//���쳣���׳��쳣
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
