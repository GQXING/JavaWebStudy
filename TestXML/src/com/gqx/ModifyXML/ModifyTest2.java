package com.gqx.ModifyXML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class ModifyTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//��ȡ����Ŀ��xml�ļ�
		Document doc=new SAXReader().read(new File("./src/contact.xml"));
			
		//�޸�doc��������
			
		//ָ���ļ������λ��
		FileOutputStream outputStream=new FileOutputStream("f://contact.xml");
//		OutputFormat format=OutputFormat.createPrettyPrint();	
	OutputFormat format=OutputFormat.createCompactFormat();	//���յĸ�ʽ
	//ָ�����ɵı��뷽ʽ,ͬʱӰ�챣��ʱ�ı��뷽ʽ��xml�ĵ������ĸ�ʽ
	format.setEncoding("utf-8");
		//����һ��д������
		XMLWriter writer=new XMLWriter(outputStream,format);
		
		//2��д������
		writer.write(doc);
		//3.�ر�io��
		writer.close();
	}

}
