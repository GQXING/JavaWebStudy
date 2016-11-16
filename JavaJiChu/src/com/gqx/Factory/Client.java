package com.gqx.Factory;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TVFactory tvFactory=new TVFactory();
		tvFactory.createTV();
		
		AirconditionFactory airconditionFactory=new AirconditionFactory();
		airconditionFactory.createAircondition();
		
		WashFactory washFactory=new WashFactory();
		washFactory.create();
	}

}
