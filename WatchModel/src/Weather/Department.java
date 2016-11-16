package Weather;

import java.util.Observable;
import java.util.Observer;

public class Department implements Observer {
	private String name;
	public Department(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	@Override
	public void update(Observable observable, Object arg) {
		// TODO Auto-generated method stub
		if(observable instanceof Weather && arg instanceof Float){  
            System.out.println("部门<"+this.name+"> :请注意了！ "+((Weather)observable).getName()+"的气温变了，"+arg+"摄氏度！");  
		}
	}
}
