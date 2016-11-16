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
		 * ��֪ͨ���й۲���֮ǰ
		 * һ��Ҫ����setChange��)���������ñ��۲��ߵ�״̬�Ѿ����ı�
		 */
		this.setChanged();
		/*
		 * notifyObservers������֪ͨ�����еĹ۲��ߺ�
		 * ���Զ�����clearChange������������۲��״̬
		 */
		this.notifyObservers(tempature);
	}
	
}
