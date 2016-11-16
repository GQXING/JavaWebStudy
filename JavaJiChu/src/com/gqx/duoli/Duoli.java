package com.gqx.duoli;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

class  Sex{
	private static final Sex male=new Sex("ÄÐ");
	private static final Sex female=new Sex("Å®");
	
	private String title;
	
	private Sex(String title){
		this.title=title;
	}
	
	public String  getSex(){
		return this.title;
	}
	public static Sex getSex(int select){
		switch (select) {
		case 0:
			return male;
		case 1:
				return female;
		default:
			return null;
		}
	}
}
public class Duoli {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 Date date = new Date();
	 String time=date.getHours()+":"+date.getMinutes()+date.getSeconds();
	System.out.println(time);
		
		Sex sex=Sex.getSex(0);
		System.out.println(sex.getSex());
	}
}
