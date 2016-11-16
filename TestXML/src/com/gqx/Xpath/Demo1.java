package com.gqx.Xpath;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Demo1 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Document doc=new SAXReader().read(new File("./src/personList.html"));
		String xpath="//tbody/tr[1]//td";
		List<Node>list=doc.selectNodes(xpath);
		for (Node node : list) {
			Element element=(Element) node;
			System.out.println(element.getText());
		}
	}

}
