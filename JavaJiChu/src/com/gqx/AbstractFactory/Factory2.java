package com.gqx.AbstractFactory;

public class Factory2 implements Factory {

	@Override
	public Wash createWash() {
		// TODO Auto-generated method stub
		return new Wash2();
	}

	@Override
	public TV createTv() {
		// TODO Auto-generated method stub
		return new TV2();
	}

}
