package Fangfa;
//�����ĸ�д����
//�����ඨ�����븸��ķ���������ͬ���������ͼ�������ͬ������ֵ��ͬ�ķ���ʱ���ͳ�Ϊ�����˸�д��
//����д�ķ�������ӵ�бȸ����Ϊ�ϸ�ķ��ʿ���Ȩ��
//public>default(ʲô����д)>private

class Father{
	
	private void say(){
		System.out.println("���Ǹ��࣡����");
	}
	public void fun(){
		this.say();
	}
	
}

class Son extends Father{
	public void say(){
//		super.say();
		System.out.println("�������࣡����");
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
