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
		System.out.println("吃苹果!");
	}
}

class Orange implements Fruite{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("吃橘子！");
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
class PropertiesOperte{//属性操作类
	private Properties pro=null;
	//与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串
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
			//将指定输入流中由 XML 文档所表示的所有属性加载到此属性表中。
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
