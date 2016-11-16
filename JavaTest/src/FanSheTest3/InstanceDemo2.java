package FanSheTest3;
/*
 * 可以看到若类中没有无参的构造方法，就会变得很麻烦
 * 所以在开发的时候为了简便，一定要在类中定义无参构造方法
 */
import java.lang.reflect.Constructor;
public class InstanceDemo2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class <?> c=null;
		Person per=null;
		c=Class.forName("FanSheTest3.Person");
		Constructor<?>  cons[]=c.getConstructors();   //取得全部的构造方法
		per=(Person)  cons[0].newInstance("MLDN",30);
		System.out.println(per);	
	}

}
