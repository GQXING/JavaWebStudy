package FactoryTest2;

interface Fruite{
	public void eat();
}

class Apple implements Fruite{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("³ÔÆ»¹û!");
	}
}

class Orange implements Fruite{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("³ÔéÙ×Ó£¡");
	}
}
class Factory{
	public static Fruite getInstance(String className){
		Fruite fruite=null;
		try {
			fruite=(Fruite) Class.forName(className).newInstance(); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return fruite;
	}
}

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruite fruite=Factory.getInstance("FactoryTest2.Apple");
		fruite.eat();
	}

}
