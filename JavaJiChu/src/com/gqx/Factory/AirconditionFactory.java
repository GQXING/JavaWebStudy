package com.gqx.Factory;

public class AirconditionFactory implements Factory {
	public Product createAircondition(){
		return new Aircondition();
	}
}
