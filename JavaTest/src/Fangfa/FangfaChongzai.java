package Fangfa;

public class FangfaChongzai {
	
	public void print(){
		System.out.println("Hello,World!");
	}
	
	public void print(int a){
		System.out.println(a);
	}
	
	public void print(int a,int b){
		System.out.println(a+b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FangfaChongzai test=new FangfaChongzai();
		test.print();
		test.print(5);
		test.print(9, 6);
	}

}
