package com.gqx.a_tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 标签的处理器类
 * @author Administrator
 *（1）、继承SimpleTagSupport
 *（2）、覆盖doTag方法，doTag里没有request的方法，我们没有办法拿到ip地址；
 *	Class SimpleTagSupport  Implemented Interfaces: JspTag, SimpleTag，肯定要实现里面的方法
 *SimpleTag的方法里面有setJspContext(JspContext pc) 这个方法，传入了JspContext
 *但是Class JspContext extended by javax.servlet.jsp.JspContext Direct Known Subclasses:PageContext
 *即JspContext的子类是pageContext，可以通过多态去强转
 */
public class ShowIpTag extends SimpleTagSupport{
//	private JspContext jspContext;
//	//实现setJspContext方法去获取pageContext对象
//	public void setJspContext(JspContext pc) {
//		this.jspContext=pc;
//	}
		@Override
		public void doTag() throws JspException, IOException {
				//因为jspContext是pageContext的子类，所以可以将jspContext向上转型
			PageContext pageContext=(PageContext) this.getJspContext();
			//通过pageContext去获取request(同样的道理，HttpServletRequest的子类是ServletRequest
			//Interface ServletReques All Known Subinterfaces: HttpServletRequest 
			 HttpServletRequest request= (HttpServletRequest) pageContext.getRequest();
			String ip=request.getRemoteHost();
			JspWriter writer=pageContext.getOut();
			writer.write("使用自定义标签获取ip地址："+ip);
		}
}
