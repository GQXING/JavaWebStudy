package com.gqx.AbstractFactory;

public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory1 factory1=new Factory1();
		factory1.createTv();
		
		Factory1 factory11=new Factory1();
		factory11.createWash();
		
	}

}
