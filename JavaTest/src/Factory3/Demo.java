package Factory3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

interface Fruite{
	public void eat();
}

class Apple implements Fruite{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("��ƻ��!");
	}
}

class Orange implements Fruite{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("�����ӣ�");
	}
}
class Factory{
	public static Fruite getInstance(String className){
		Fruite fruite=null;
		try {
			fruite=(Fruite) Class.forName(className).newInstance(); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return fruite;
	}
}
class PropertiesOperte{//���Բ�����
	private Properties pro=null;
	//��ϵͳ�йص�Ĭ�����Ʒָ�����Ϊ�˷��㣬������ʾΪһ���ַ���
	private File file=new File("d:"+File.separator+"fruite.properties");
	public  PropertiesOperte() throws InvalidPropertiesFormatException, FileNotFoundException, IOException{
		this.pro=new Properties();
		if (file.exists()) {
			pro.loadFromXML(new FileInputStream(file));
		}else {
			this.save();
		}
	}
	public void save(){
		this.pro.setProperty("apple", "Factory3.Apple");
		this.pro.setProperty("orange", "Factory3.Orange");
		try {
			//��ָ������������ XML �ĵ�����ʾ���������Լ��ص������Ա��С�
			this.pro.storeToXML(new FileOutputStream(this.file), "fruite");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Properties getProperties(){
		return this.pro; 
	}
}
public class Demo {
	public static void main(String[] args) throws InvalidPropertiesFormatException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Properties properties=new PropertiesOperte().getProperties();
		Fruite fruite=Factory.getInstance(properties.getProperty("apple"));
		fruite.eat();
	}
}
