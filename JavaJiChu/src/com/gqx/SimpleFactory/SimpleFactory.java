package com.gqx.SimpleFactory;
public class SimpleFactory {
	public static Product getProduct(String name){
		if (name.equals("wash")) {
			return new Wash();
		}else if (name.equals("TV")) {
			return new TV();
		}else if (name.equals("Aircondition")) {
			return new Aircondition();
		}else {
			return null;
		}
	}
}
