package com.gqxing.entity;

public class Student {
	private String ID;
	private String classString;
	private String name;
	private String sex;
	private String city;
	private String Birth;
	private String mobile;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getClassString() {
		return classString;
	}
	public void setClassString(String classString) {
		this.classString = classString;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		Birth = birth;
	}
	public String getMonile() {
		return mobile;
	}
	public void setMonile(String monile) {
		this.mobile = monile;
	}
	public Student(String iD, String classString, String name, String sex,
			String city, String birth, String monile) {
		super();
		ID = iD;
		this.classString = classString;
		this.name = name;
		this.sex = sex;
		this.city = city;
		Birth = birth;
		this.mobile = monile;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [ID=" + ID + ", class=" + classString + ", name="
				+ name + ", sex=" + sex + ", city=" + city + ", Birth=" + Birth
				+ ", mobile=" + mobile + "]";
	}
	
	
}
