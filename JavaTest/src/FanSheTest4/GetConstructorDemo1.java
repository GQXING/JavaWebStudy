package FanSheTest4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class GetConstructorDemo1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class<?> c=Class.forName("FanSheTest4.Person");
		Constructor<?> constructor[]= c.getConstructors(); //�õ�ȫ���Ĺ��췽��
		for (int i = 0; i < constructor.length; i++) {
			int mod=constructor[i].getModifiers();  //�õ����η�
			String string=Modifier.toString(mod);	//��ԭȨ��
			Class<?> param[]=constructor[i].getParameterTypes(); //�õ�ȫ���Ĳ���
			System.out.print(string+"  "); //�������
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
