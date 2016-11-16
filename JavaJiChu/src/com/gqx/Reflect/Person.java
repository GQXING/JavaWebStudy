package com.gqx.Reflect;

class Person {
	private String name;
	public int age;
	 public int add(int para1,int para2){
			return para1+para2;
		}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	 public String toString(){
		 return "["+this.name+"    "+this.age+"]";
	 }
	 public Person(String name, int age) { 
	        this.age=age; 
	        this.name=name; 
	    } 
	 public Person() { 
	  
	    } 
	 
	 public String say(String message){
		 return message;
	 }
	
	 
}
