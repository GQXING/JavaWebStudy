package FanSheTest;

public class Demo4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Class<?> c=null;
			try {
				c=Class.forName("FanSheTest.Person");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println(c.getName());
	}
}
