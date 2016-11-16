package com.gqx.AbstractFactory;
public class Factory1 implements Factory {
	@Override
	public Wash createWash() {
		// TODO Auto-generated method stub
		return new Wash1();
	}

	@Override
	public TV createTv() {
		// TODO Auto-generated method stub
		return new TV1();
	}

}
