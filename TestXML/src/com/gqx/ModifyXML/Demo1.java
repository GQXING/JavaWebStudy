package com.gqx.ModifyXML;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
/*
 * 
 */

public class Demo1 {
	@Test
  public void Test1()throws Exception{
	  //创建文档
		Document document=DocumentHelper.createDocument();
		//增加标签
		Element rootElement=document.addElement("contractList");
		Element contactElement=rootElement.addElement("contact");
		Element namElement=contactElement.addElement("name");
		namElement.setText("LIS");
		/*
		 * 添加属性
		 */
		contactElement.addAttribute("id", "001");
	//将修改后的document写入都指定xml文档中
		//指定文件的输出位置
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		FileOutputStream outputStream =new FileOutputStream("e:/contact2.xml");
		
		
		//创建写出对象
		XMLWriter writer=new XMLWriter(outputStream,format);
		writer.write(document);
		//关闭资源
		outputStream.close();
  }
	
	/*
	 * 修改，属性值、文本
	 */
	@Test
	public void test2() throws Exception{
		Document document=new SAXReader().read(new File("./src/contact.xml"));
		//1、修改属性值 1、得到标签  2、得到属性对象 3、修改属性值
		Element conelement=document.getRootElement().element("contact");
		Attribute idAttr=conelement.attribute("id");
		idAttr.setValue("哈哈哈");
		Element nameElement=conelement.element("name");
		//nameElement.setText("郭大帅");
		
		nameElement.detach();
		
		//删除属性值
		Element conElement2=(Element) document.getRootElement().elements().get(1);
		Attribute attribute=conElement2.attribute("id");
		attribute.detach();
		
		FileOutputStream outputStream =new FileOutputStream("e:/contact.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer=new XMLWriter(outputStream,format);
		
		writer.write(document);
		writer.close();
	}
}
