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
            System.out.println("����<"+this.name+"> :��ע���ˣ� "+((Weather)observable).getName()+"�����±��ˣ�"+arg+"���϶ȣ�");  
		}
	}
}
