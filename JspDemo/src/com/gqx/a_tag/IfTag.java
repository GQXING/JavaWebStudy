package com.gqx.a_tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfTag extends SimpleTagSupport {
	//�������
	private boolean test;
	public void setTest(boolean test){
		this.test=test;
	}
	@Override
	public void doTag() throws JspException, IOException {
		//����test�ķ��ص����ݾ����Ƿ��������
		if (test) {
			this.getJspBody().invoke(null);
		}
	}
}
