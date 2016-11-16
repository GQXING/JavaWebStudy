package FanSheTest2;

public class InstanceDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class <?> c=null;
		try {
			c=Class.forName("FanSheTest2.Person");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			Person p=(Person) c.newInstance();
			System.out.println(p);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
