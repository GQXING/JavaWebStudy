package com.gqx.Leibulei;

public class Cow{
	private double weight;
	//�ⲿ����������صĹ�����
	public Cow(){
		
	}
	public Cow(double weight){
		this.weight=weight;
	}
	//����һ���Ǿ�̬���ڲ���
	private class CowLeg
	{
		//�Ǿ�̬�ڲ��������ʵ������
		private double length;
		private String color;
		//�Ǿ�̬�ڲ�����������صĹ�����
		public CowLeg(){
			
		}
		public CowLeg(double length,String color){
			this.length=length;
			this.color=color;
		}
		public double getLength() {
			return length;
		}
		public void setLength(double length) {
			this.length = length;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		
		public void info()
		{
			System.out.println("��ǰţ�ȵ���ɫ�ǣ�"+color+"���ߣ�"+length);
			//ֱ�ӷ����ⲿ���private���εĳ�Ա����
			System.out.println("��ţ�����ڵ�ţ���ڣ�"+weight);
		}
		
	}
	
	public void test(){
		CowLeg cl=new CowLeg(1.12,"�ڰ����");
		cl.info();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cow cow=new Cow(378.5);
		cow.test();
	}

}
