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
	 * 首页：查询所有商品的servlet
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		//查询“数据库”，读出所有的商品。
		ProductDao dao=new ProductDao();		//对操作对象的实例化
		List<Product> products=dao.findAll();
		
		PrintWriter out = response.getWriter();
		
		//把所有的产品显示到浏览器中
		String html="";
		html+="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"><HTML><HEAD><TITLE>所有商品列表</TITLE></HEAD><BODY>";
		html+="<table width='600px' border='1' align='center'>";
		html+="<tr><th>编号</th><th>商品名称</th><th>商品类型</th></tr>";
		//遍历所有的商品
		for(Product product:products){
			String path=request.getContextPath()+"/DetailServlet?id="+product.getId();
			html+="<tr><td>"+product.getId()+"</td><td>"+product.getName()+"</td><td><a href='"+path+"'>详细信息</a></td></tr>";
		}
		html+="  </table>";
		
		
		//处理上一次访问的cookie，得到上一次啊访问的数据
		String str="</br>";
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("proHist")) {
					str+="你上次浏览的商品是：</br>";
					String proHist=cookie.getValue();
					String[] ids=proHist.split(",");
					for (String string : ids) {
						//查询“数据库”，查询对于的商品
						Product p=dao.getProduct(string);
						//显示在浏览器上
						str+=p.getId()+" &nbsp;"+p.getName()+" &nbsp;"+p.getPrice()+"</br>";
					}
				}
			}
		}else {
			str+="<p>你是第一次访问本网站</p>";
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
