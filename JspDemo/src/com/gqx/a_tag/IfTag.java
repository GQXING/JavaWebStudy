package com.gqx.a_tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfTag extends SimpleTagSupport {
	//添加属性
	private boolean test;
	public void setTest(boolean test){
		this.test=test;
	}
	@Override
	public void doTag() throws JspException, IOException {
		//根据test的返回的内容决定是否输出内容
		if (test) {
			this.getJspBody().invoke(null);
		}
	}
}
