package com.gqx.Xpath;
import java.io.File;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XpathHtml {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Document doc=new SAXReader().read(new File("./src/personList.html"));
		List<Node> list =doc.selectNodes("//thead/tr//th");
		String[] s=new String[6]; 
		int i=0;
		for (Node node : list) {
			Element elem=(Element) node;
			s[i]=elem.getText(); i++;
		}
		List<Node> list2 =doc.selectNodes("//tbody//tr");
		String[] s2=new String[6];
		for(int k=1;k<list2.size()+1;k++){
			s2=getString(k, doc);
			for (int j = 0; j < s2.length; j++) {
				System.out.print(s[j]+":"+s2[j]+" ");
			}
			System.out.println();
		}
	}
	public static String[] getString(int i,Document document){
		List<Node> list=document.selectNodes("//tbody/tr["+i+"]//td");
		int j=0;
		String[] s=new String[6];
		for (Node node : list) {
			Element element=(Element)node;
			s[j]=element.getText();  j++;
		}
		return s;
	}
}
