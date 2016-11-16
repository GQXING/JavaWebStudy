package com.gqx.Factory;


public class TVFactory implements Factory {
	public Product createTV(){
		return new TV();
	}
}
