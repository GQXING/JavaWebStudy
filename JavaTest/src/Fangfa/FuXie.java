package Fangfa;
//�����ĸ�д����
//�����ඨ�����븸��ķ���������ͬ���������ͼ�������ͬ������ֵ��ͬ�ķ���ʱ���ͳ�Ϊ�����˸�д��
//����д�ķ�������ӵ�бȸ����Ϊ�ϸ�ķ��ʿ���Ȩ��
//public>default(ʲô����д)>private

class People{
	
	public void say(){
		System.out.println("���Ǹ��࣡����");
	}
	public void fun(){
		this.say();
	}
	
}

class Student extends People{
	public void say(){
    	super.say();
		System.out.println("�������࣡����");
	}
}
public class FuXie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student=new Student();
		student.say();
		System.out.println();
		student.fun();
	}

}
