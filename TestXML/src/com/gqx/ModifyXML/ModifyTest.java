package com.gqx.ModifyXML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class ModifyTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//读取本项目的xml文件
		Document doc=new SAXReader().read(new File("./src/contact.xml"));
		
		
		//修改doc对象内容
		
		
		
		
		//指定文件输出的位置
		FileOutputStream outputStream=new FileOutputStream("./src/contact.xml");
		
		OutputFormat format=OutputFormat.createPrettyPrint();
		//创建一个写出对象
		XMLWriter writer=new XMLWriter(outputStream);
		
		//2、写出对象
		writer.write(doc);
		
		//3.关闭io流
		writer.close();
	}

}
