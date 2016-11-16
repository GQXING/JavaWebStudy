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
	  //�����ĵ�
		Document document=DocumentHelper.createDocument();
		//���ӱ�ǩ
		Element rootElement=document.addElement("contractList");
		Element contactElement=rootElement.addElement("contact");
		Element namElement=contactElement.addElement("name");
		namElement.setText("LIS");
		/*
		 * �������
		 */
		contactElement.addAttribute("id", "001");
	//���޸ĺ��documentд�붼ָ��xml�ĵ���
		//ָ���ļ������λ��
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		FileOutputStream outputStream =new FileOutputStream("e:/contact2.xml");
		
		
		//����д������
		XMLWriter writer=new XMLWriter(outputStream,format);
		writer.write(document);
		//�ر���Դ
		outputStream.close();
  }
	
	/*
	 * �޸ģ�����ֵ���ı�
	 */
	@Test
	public void test2() throws Exception{
		Document document=new SAXReader().read(new File("./src/contact.xml"));
		//1���޸�����ֵ 1���õ���ǩ  2���õ����Զ��� 3���޸�����ֵ
		Element conelement=document.getRootElement().element("contact");
		Attribute idAttr=conelement.attribute("id");
		idAttr.setValue("������");
		Element nameElement=conelement.element("name");
		//nameElement.setText("����˧");
		
		nameElement.detach();
		
		//ɾ������ֵ
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
