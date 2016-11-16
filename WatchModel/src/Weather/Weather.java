package Weather;

import java.util.Observable;

public class Weather extends Observable{
	private String name;
	private float temperature;
	
	public Weather(String name ,float temperature){
		this.name=name;
		this.temperature=temperature;
	}
	
	public String getName(){
		return name;
	}
	
	
	public Float getTempature(){
		this.notifyObservers(temperature);
		return temperature;
	}
	
	public void setTempature(float tempature){
		this.temperature=tempature;
		/*
		 * 在通知所有观察者之前
		 * 一定要调用setChange（)方法来设置被观察者的状态已经被改变
		 */
		this.setChanged();
		/*
		 * notifyObservers方法在通知完所有的观察者后
		 * 会自动调用clearChange方法来清除被观察的状态
		 */
		this.notifyObservers(tempature);
	}
	
}
