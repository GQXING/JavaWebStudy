package com.gqx.ChooseTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//choose��ǩֻ��Ҫִ����������ݾ�����
public class Choose extends SimpleTagSupport {
	//������ʱ���󣬼��ӱ�ǩ��when�е��ж�ֵ
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
