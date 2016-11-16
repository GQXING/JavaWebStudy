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
	 * 商品详细信息页面
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		ProductDao products=new ProductDao();
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>商品详细信息</TITLE></HEAD>");
		out.println("  <BODY>");
		String id=request.getParameter("id");
		Product product=products.getProduct(id);
		//打印出具体的商品信息
		String html="";
		html+="<table width='300px' border='1' align='center'>";
		html+="<tr><th>"+product.getId()+"产品的信息</th></tr>";
		html+="<tr><td>商品编号：</td><td>"+product.getId()+"</td><tr><td>商品名称：</td><td>"+product.getName()+"</td></tr><tr><td>商品类型</td><td>"+product.getProType()+"</td></tr><tr><td>商品价格：</td><td>"+product.getPrice()+"</td></tr>";
		html+="<center><a href='"+request.getContextPath()+"/ListServlet'>返回上一级</a></center>";
		out.print(html);
		out.println("  </table>");
		
		//设置cookie值
		Cookie cookie =new Cookie("proHist", createValue(request,id));
		cookie.setMaxAge(30*24*60*60);
		response.addCookie(cookie);
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	

	/**
	 * 显示以前访问的商品，如何保存其cookie值
	 * @param request
	 * @return
	 *    当前cookie  				传入 id				最终的cookie
	 *    		无								1							1
	 * 			1									2							2,1
	 * 			2,1								1							1,2
	 * 			1,2								3							3,1,2
	 */

	private String createValue(HttpServletRequest request,String id) {
		// TODO Auto-generated method stub
		Cookie[] cookies=request.getCookies();
		String proHist=null;
		
		if (cookies!=null) {
		//如果浏览器端有cookie，则从其中取回cookie值
			for (Cookie cookie : cookies) {
				//查找名为proHist的cookie
				if (cookie.getName().equals("proHist")) {
					proHist=cookie.getValue();
				}	
			}
		}
		
		//如果cookie为空或者proHist为空，则返回当前id
		if (cookies==null || proHist==null) {
			return id;
		}
		
		/**
		 * 剩下的则是对字符串中的cookie值（形如[1,2,3]）进行操作,但对仅仅对字符串操作太过于麻烦
		 * 这个时候我们可以换一种思维，将其转化为集合的形式 在jdk中有一个方法直接将字符串数组转化为list的形式   
		 *  static <T> List<T> asList(T... a)  返回一个受指定数组支持的固定大小的列表。 
		 *  同时Collection又是List的子接口
		 */
		String string[]=proHist.split(",");
		Collection<String> collection = Arrays.asList(string);
		
		/**
		 * 这个时候我们又发现了一个问题，即便是集合，但是对集合的频繁操作太过于麻烦，而且集合缺少一些方便删除添加的操作
		 * 我们知道对列表的频繁操作，最方便的是linkedlist链接，我们又发现在jdk中有如下的方法，可以方便我们查找
		 * LinkedList(Collection<? extends E> c) 构造一个包含指定 collection 中的元素的列表，这些元素按其 collection 的迭代器返回的顺序排列
		 */
		
		LinkedList list=new LinkedList(collection);
		
		
		if (list.size()<3) {
			//首先判断该cookie值是否超过三个
			if (list.contains(id)) {
				//当cookie值中重复 (id=1    cookie=2,1)
				list.remove(id);
				list.addFirst(id);
			}else {
				list.addFirst(id);
			}
		}else {
			//其次判断该cookie值若超过三个
			if (list.contains(id)) {
				//当cookie值中重复 (id=1    cookie=2,1,3)
				list.remove(id);
				list.addFirst(id);
			}else {
				//不重复，去掉最后一个，将id加到第一个去
				list.removeLast();
				list.addFirst(id);
			}
		}
		
		//将集合转化为字符串
		String valueString="";
		for (Object object : list) {
			valueString+=object+",";
		}
		
		//去掉多余的逗号
		valueString=valueString.substring(0, valueString.length()-1);
		return valueString;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
