package com.gqxservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gqx.entity.Product;
import com.gqx.productDao.ProductDao;

public class DetailServlet extends HttpServlet {

	/**
	 * ��Ʒ��ϸ��Ϣҳ��
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		ProductDao products=new ProductDao();
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>��Ʒ��ϸ��Ϣ</TITLE></HEAD>");
		out.println("  <BODY>");
		String id=request.getParameter("id");
		Product product=products.getProduct(id);
		//��ӡ���������Ʒ��Ϣ
		String html="";
		html+="<table width='300px' border='1' align='center'>";
		html+="<tr><th>"+product.getId()+"��Ʒ����Ϣ</th></tr>";
		html+="<tr><td>��Ʒ��ţ�</td><td>"+product.getId()+"</td><tr><td>��Ʒ���ƣ�</td><td>"+product.getName()+"</td></tr><tr><td>��Ʒ����</td><td>"+product.getProType()+"</td></tr><tr><td>��Ʒ�۸�</td><td>"+product.getPrice()+"</td></tr>";
		html+="<center><a href='"+request.getContextPath()+"/ListServlet'>������һ��</a></center>";
		out.print(html);
		out.println("  </table>");
		
		//����cookieֵ
		Cookie cookie =new Cookie("proHist", createValue(request,id));
		cookie.setMaxAge(30*24*60*60);
		response.addCookie(cookie);
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	

	/**
	 * ��ʾ��ǰ���ʵ���Ʒ����α�����cookieֵ
	 * @param request
	 * @return
	 *    ��ǰcookie  				���� id				���յ�cookie
	 *    		��								1							1
	 * 			1									2							2,1
	 * 			2,1								1							1,2
	 * 			1,2								3							3,1,2
	 */

	private String createValue(HttpServletRequest request,String id) {
		// TODO Auto-generated method stub
		Cookie[] cookies=request.getCookies();
		String proHist=null;
		
		if (cookies!=null) {
		//������������cookie���������ȡ��cookieֵ
			for (Cookie cookie : cookies) {
				//������ΪproHist��cookie
				if (cookie.getName().equals("proHist")) {
					proHist=cookie.getValue();
				}	
			}
		}
		
		//���cookieΪ�ջ���proHistΪ�գ��򷵻ص�ǰid
		if (cookies==null || proHist==null) {
			return id;
		}
		
		/**
		 * ʣ�µ����Ƕ��ַ����е�cookieֵ������[1,2,3]�����в���,���Խ������ַ�������̫�����鷳
		 * ���ʱ�����ǿ��Ի�һ��˼ά������ת��Ϊ���ϵ���ʽ ��jdk����һ������ֱ�ӽ��ַ�������ת��Ϊlist����ʽ   
		 *  static <T> List<T> asList(T... a)  ����һ����ָ������֧�ֵĹ̶���С���б� 
		 *  ͬʱCollection����List���ӽӿ�
		 */
		String string[]=proHist.split(",");
		Collection<String> collection = Arrays.asList(string);
		
		/**
		 * ���ʱ�������ַ�����һ�����⣬�����Ǽ��ϣ����ǶԼ��ϵ�Ƶ������̫�����鷳�����Ҽ���ȱ��һЩ����ɾ����ӵĲ���
		 * ����֪�����б��Ƶ��������������linkedlist���ӣ������ַ�����jdk�������µķ��������Է������ǲ���
		 * LinkedList(Collection<? extends E> c) ����һ������ָ�� collection �е�Ԫ�ص��б���ЩԪ�ذ��� collection �ĵ��������ص�˳������
		 */
		
		LinkedList list=new LinkedList(collection);
		
		
		if (list.size()<3) {
			//�����жϸ�cookieֵ�Ƿ񳬹�����
			if (list.contains(id)) {
				//��cookieֵ���ظ� (id=1    cookie=2,1)
				list.remove(id);
				list.addFirst(id);
			}else {
				list.addFirst(id);
			}
		}else {
			//����жϸ�cookieֵ����������
			if (list.contains(id)) {
				//��cookieֵ���ظ� (id=1    cookie=2,1,3)
				list.remove(id);
				list.addFirst(id);
			}else {
				//���ظ���ȥ�����һ������id�ӵ���һ��ȥ
				list.removeLast();
				list.addFirst(id);
			}
		}
		
		//������ת��Ϊ�ַ���
		String valueString="";
		for (Object object : list) {
			valueString+=object+",";
		}
		
		//ȥ������Ķ���
		valueString=valueString.substring(0, valueString.length()-1);
		return valueString;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
