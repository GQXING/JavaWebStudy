package com.gqx.a_tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DemoTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
			System.out.println("标签执行了");
			/**
			 * 控制标签是否输出
			 */
			//1、1得到标签体的内容
			JspFragment jspBody=this.getJspBody();
			//执行invoke方法，会把标签体内容输出到指定的Writer对象中
			//JspWriter out=this.getJspContext().getOut();
			//输出标签体内容	//不想输出标签体的内容可以不去调用它
			//jspBody.invoke(out);
			/**源文档
			 * invoke(java.io.Writer out)Executes the fragment and directs all output to the given Writer, 
			 *  or the JspWriter returned by the getOut() method of the JspContext associated with the fragment if out is null.
			 *  默认空直接往浏览器输出内容
			 */
			//jspBody.invoke(null);
			
			
			/**
			 * 2、控制标签余下内容是否输出
			 * 默认是输出的
			 * 不输出：抛出SkipPageException异常
			 */
			//throw new SkipPageException();
			
			/**
			 *3、重复输出标签体内容,执行多次invoke方法
			 */
			for (int i = 0; i < 5; i++) {
				jspBody.invoke(null);
			}
			
			/**
			 * 4/改变表前体的内容
			 */
			//StringWrite临时的容器，以字符串的形式返回该缓冲区的当前值。
			StringWriter sw=new StringWriter();
			//将标签体内容放入到临时的容器
			jspBody.invoke(sw);
			//从临时容器得到标签体的内容
			String content=sw.toString();
			//改变标签体的内容
			content=content.toLowerCase();
			//把标签体内容输出到浏览器
			//不能使用jspBody.invoke(null);因为jspBody的内容没有改变
			this.getJspContext().getOut().write(content);
	}
}
