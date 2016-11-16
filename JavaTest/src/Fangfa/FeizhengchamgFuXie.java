package Fangfa;
//方法的覆写概念
//当子类定义了与父类的方法名称相同、参数类型及个数相同、返回值相同的方法时，就称为发生了覆写。
//但覆写的方法不能拥有比父类更为严格的访问控制权限
//public>default(什么都不写)>private

class Father{
	
	private void say(){
		System.out.println("我是父类！！！");
	}
	public void fun(){
		this.say();
	}
	
}

class Son extends Father{
	public void say(){
//		super.say();
		System.out.println("我是子类！！！");
	}
}
public class FeizhengchamgFuXie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Son son=new Son();
//		son.say();
		son.fun();
	}

}
