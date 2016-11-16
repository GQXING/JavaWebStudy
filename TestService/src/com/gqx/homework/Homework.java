package com.gqx.homework;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Homework extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 添加联系人，把contact保存到xml文档中
		 */
		File file=new File("/WEB-INF/classes/student.xml");
		Document doc=null;
		Element rootElem=null;
		if (file.exists()) {
		
			System.out.println("jj");
		}else {
			System.out.println("yy");
			doc=DocumentHelper.createDocument();
			rootElem=doc.addElement("contactList");
		}
		try {
			XMLUtil.write2xml(doc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//			try {
//				doc=new SAXReader().read(file);
//			} catch (DocumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			rootElem=doc.getRootElement();
//		}else {
//			//如果没有xml文件，创建xml文件
//			doc=DocumentHelper.createDocument();
//			rootElem=doc.addElement("contactList");
//		}
	
//			
//			
//			//添加contact标签
//		Element contactElem=rootElem.addElement("contact");
//			
//		Enumeration<String> enums=request.getParameterNames();
//		while (enums.hasMoreElements()) {
//			String para = (String) enums.nextElement();
//			String value=request.getParameter(para);
//			value=new String(value.getBytes("iso-8859-1"),"utf-8");
//			if ("id".equals(para)) {
//				rootElem.addAttribute(para, value);
//			}else {
//				rootElem.addElement(para).setText(value);;
//			}
//		}

		
	}

}
