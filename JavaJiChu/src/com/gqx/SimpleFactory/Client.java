package com.gqx.SimpleFactory;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product =SimpleFactory.getProduct("wash");
		Product product2 =SimpleFactory.getProduct("TV");
		Product product3=SimpleFactory.getProduct("Aircondition");
	}
}
