package com.gqx.Xpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XpathLogin {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//ͨ��InputStreamReaderת������System.in���ֽ���ת��Ϊ�ַ�����ȡ�û�����
		BufferedReader br=new BufferedReader( new InputStreamReader(System.in));
		System.out.println("�������û�����");
		String name=br.readLine();
		System.out.println("���������룺");
		String password=br.readLine();
		String path="//user[@name='"+name+"' and @password='"+password+"']";
		
		Element element=(Element) new SAXReader().read("./src/user.xml").selectSingleNode(path);
		
		if (element==null) {
			System.out.println("�û�����������󣬵���ʧ�ܣ�");
		}else {
			System.out.println("����ɹ���");
		}
	}
}
