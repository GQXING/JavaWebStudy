package com.gqxservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gqx.entity.Product;
import com.gqx.productDao.ProductDao;

public class ListServlet extends HttpServlet {

	/**
	 * ��ҳ����ѯ������Ʒ��servlet
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		//��ѯ�����ݿ⡱���������е���Ʒ��
		ProductDao dao=new ProductDao();		//�Բ��������ʵ����
		List<Product> products=dao.findAll();
		
		PrintWriter out = response.getWriter();
		
		//�����еĲ�Ʒ��ʾ���������
		String html="";
		html+="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"><HTML><HEAD><TITLE>������Ʒ�б�</TITLE></HEAD><BODY>";
		html+="<table width='600px' border='1' align='center'>";
		html+="<tr><th>���</th><th>��Ʒ����</th><th>��Ʒ����</th></tr>";
		//�������е���Ʒ
		for(Product product:products){
			String path=request.getContextPath()+"/DetailServlet?id="+product.getId();
			html+="<tr><td>"+product.getId()+"</td><td>"+product.getName()+"</td><td><a href='"+path+"'>��ϸ��Ϣ</a></td></tr>";
		}
		html+="  </table>";
		
		
		//������һ�η��ʵ�cookie���õ���һ�ΰ����ʵ�����
		String str="</br>";
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("proHist")) {
					str+="���ϴ��������Ʒ�ǣ�</br>";
					String proHist=cookie.getValue();
					String[] ids=proHist.split(",");
					for (String string : ids) {
						//��ѯ�����ݿ⡱����ѯ���ڵ���Ʒ
						Product p=dao.getProduct(string);
						//��ʾ���������
						str+=p.getId()+" &nbsp;"+p.getName()+" &nbsp;"+p.getPrice()+"</br>";
					}
				}
			}
		}else {
			str+="<p>���ǵ�һ�η��ʱ���վ</p>";
		}
		
		html=html+str;
		html+="</BODY></HTML>";
		out.write(html);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
