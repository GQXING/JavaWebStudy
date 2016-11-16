package FactoryTest;

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
		if (className.equals("apple")) {
			fruite=new Apple();
		}
		if (className.equals("orange")) {
			fruite=new Orange();
		}
		return fruite;
	}
}

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruite fruite=Factory.getInstance("apple");
		fruite.eat();
	}

}
