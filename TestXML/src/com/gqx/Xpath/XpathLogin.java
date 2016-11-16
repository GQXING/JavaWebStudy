package com.gqx.Xpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XpathLogin {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//通过InputStreamReader转换流把System.in的字节流转化为字符流获取用户输入
		BufferedReader br=new BufferedReader( new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String name=br.readLine();
		System.out.println("用输入密码：");
		String password=br.readLine();
		String path="//user[@name='"+name+"' and @password='"+password+"']";
		
		Element element=(Element) new SAXReader().read("./src/user.xml").selectSingleNode(path);
		
		if (element==null) {
			System.out.println("用户名或密码错误，登入失败！");
		}else {
			System.out.println("登入成功！");
		}
	}
}
