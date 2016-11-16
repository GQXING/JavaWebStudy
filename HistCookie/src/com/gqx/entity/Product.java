package com.gqx.entity;

public class Product {
	private String id;
	private String name;
	private float price;
	private String proType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String id, String name, float price, String proType) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.proType = proType;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ ", proType=" + proType + "]";
	}
	

}
