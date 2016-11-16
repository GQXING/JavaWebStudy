package com.gqx.ChooseTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//choose标签只需要执行里面的内容就行了
public class Choose extends SimpleTagSupport {
	//保存临时对象，即子标签中when中的判断值
	private boolean flag;
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public boolean isFlag() {
		return flag;
	}
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspBody().invoke(null);
	}
}
