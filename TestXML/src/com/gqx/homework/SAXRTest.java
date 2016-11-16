package com.gqx.homework;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class SAXRTest {
	
	private static Element rootElement=null;
	private static Document doc=null;
	public  SAXRTest() throws Exception{
		Document document=new SAXReader().read(new File("./src/c.xml"));
		rootElement=document.getRootElement();
		doc=document;
	}
	
	public void addContract(Contact contact) throws Exception{
		Element elem=rootElement.addElement("contract");
		elem.addAttribute("id", contact.getId());
		elem.addElement("name").setText(contact.getName());
		elem.addElement("sex").setText(contact.getSex());
		elem.addElement("age").setText(contact.getAge());
		elem.addElement("phone").setText(contact.getPhone());
		elem.addElement("qq").setText(contact.getQq());
		elem.addElement("email").setText(contact.getEmail());

		FileOutputStream out=new FileOutputStream("./src/c.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer=new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}
	
	public void Show(){
		String xpath="//name";
		List<Node>list=doc.selectNodes(xpath);
		for (Node node : list) {
			Element element=(Element) node;
			System.out.println(element.getText());
		}
	}
	
	
}
