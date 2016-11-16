package com.gqx.a_tag;

import java.io.IOException;
import java.util.List;


import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.google.common.collect.Multiset.Entry;

public class Foreach extends SimpleTagSupport {
	private Object items;
	private String var;
	public void setItems(Object items) {
		this.items = items;
	}
	public void setVar(String var) {
		this.var = var;
	}
	@Override
	public void doTag() throws JspException, IOException {
		//得到当前页面的pagecontex，方便在后面的操作中将值插入域对象中
		PageContext context=(PageContext) this.getJspContext();
		//这里只判断List对象
		if (items instanceof List) {
			List list=(List)items;
			for (Object object : list) {
				//将对应的值传入域对象，用以在如下形式的方式输出
				//姓名：${student.name } - 年龄:${student.age }
				context.setAttribute(var, object);
				//输出到页面上去
				this.getJspBody().invoke(null);
			}
		}
		
		//Map
				if(items instanceof Map){
					Map map = (Map)items;
					Set<Entry> entrySet = map.entrySet();
					for(Entry entry :entrySet){
						//把每个对象放入域对象中(pageContext)
						context.setAttribute(var, entry);
						//显示标签体内容
						this.getJspBody().invoke(null);
					}
				}
		
	}
}
