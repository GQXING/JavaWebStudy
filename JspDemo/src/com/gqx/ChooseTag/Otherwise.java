package com.gqx.ChooseTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//完成otherwise功能 
public class Otherwise extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		//从父标签中获取When判断的结果
		Choose parent=(Choose)this.getParent();
		Boolean test=parent.isFlag();
		if (!test) {
			this.getJspBody().invoke(null);
		}
		
	}
}
