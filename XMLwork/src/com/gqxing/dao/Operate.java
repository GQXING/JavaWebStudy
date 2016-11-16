package com.gqxing.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gqxing.dao.XMLUtil;
import com.gqxing.entity.Student;

public class Operate {
	private static List<Student> students=new ArrayList<>();
	public static String nameSpace = "http://www.w3.org/2001/XMLSchema-instance";
	
	public void addStudent(Student student) throws Exception{
		/**
		 * �����ϵ�ˣ���student���浽xml�ĵ���
		 */
		File file=new File("e:/xmlwork/student.xml");
		Document doc=null;
		Element rootElem=null;
		if (file.exists()) {
			doc=new SAXReader().read(file);
			rootElem=doc.getRootElement();
		}else {
			//���û��xml�ļ�������xml�ļ�
			doc=DocumentHelper.createDocument();
			rootElem=doc.addElement("Students");
			rootElem.addNamespace("xsi", nameSpace);
			rootElem.addAttribute("xsi:noNamespaceSchemaLocation", "student.xsd");
		}
		
		//���ѧ������
		Element element=rootElem.addElement("Student");
		element.addAttribute("Id", student.getID());
		element.addAttribute("Class", student.getClassString());
		element.addElement("Name").setText(student.getName());
		element.addElement("Sex").setText(student.getSex());
		element.addElement("Birth").setText(student.getBirth());
		element.addElement("City").setText(student.getCity());
		element.addElement("Mobile").setText(student.getMonile());
		
		XMLUtil.write2xml(doc);
	}
	
	
	public void remove(String id) throws Exception{
		Document document=XMLUtil.getDocument();
		Element stuElement=(Element) document.selectSingleNode("//Student[@Id='"+id+"']");
		//ɾ���ڵ�
		stuElement.detach();
		XMLUtil.write2xml(document);
	}
	
	
	public List<Student> getStudents(){
		Document doc=XMLUtil.getDocument();
		//����list����
		List<Student> list=new ArrayList<Student>();
		//ʹ��xpathȥ�������еĽڵ�
		List<Element> conList=(List<Element>)doc.selectNodes("//Student");
		for (Element element : conList) {
			Student student=new Student();
			student.setID(element.attributeValue("Id"));
			student.setClassString(element.attributeValue("Class"));
			student.setName(element.elementText("Name"));
			student.setSex(element.elementText("Sex"));
			student.setBirth(element.elementText("Birth"));
			student.setCity(element.elementText("City"));
			student.setMonile(element.elementText("Mobile"));
			list.add(student);
		}
		
		return list;
	}
	
	
}
