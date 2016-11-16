package com.gqx.Factory;

public class WashFactory implements Factory {
	public Product create(){
		return new Wash();
	}
}
