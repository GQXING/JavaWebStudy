package FanSheTest3;
/*
 * ���Կ���������û���޲εĹ��췽�����ͻ��ú��鷳
 * �����ڿ�����ʱ��Ϊ�˼�㣬һ��Ҫ�����ж����޲ι��췽��
 */
import java.lang.reflect.Constructor;
public class InstanceDemo2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class <?> c=null;
		Person per=null;
		c=Class.forName("FanSheTest3.Person");
		Constructor<?>  cons[]=c.getConstructors();   //ȡ��ȫ���Ĺ��췽��
		per=(Person)  cons[0].newInstance("MLDN",30);
		System.out.println(per);	
	}

}
