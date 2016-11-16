package com.gqx.ChooseTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//When标签需要做判断
public class When extends SimpleTagSupport {
	private boolean test;
	public void setTest(boolean test){
		this.test=test;
	}
	@Override
	public void doTag() throws JspException, IOException {
		if (test) {
			this.getJspBody().invoke(null);
		}
		//因为choose标签下面另一个子标签othsewhise需要做判断，
		//而otherwise没有属性，需要通过父标签传递判断的结果,
		//将结果保存在父标签中的flag中。
		//获取父标签
		Choose parent=(Choose)this.getParent();
		parent.setFlag(test);
	}
}
