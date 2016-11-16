package FanSheTest4;

public class GetSuperClassDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class<?> c=Class.forName("FanSheTest.Person");
		Class<?> sc=c.getSuperclass();
		System.out.println(sc.getName());
	}

}
