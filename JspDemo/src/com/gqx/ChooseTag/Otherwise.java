package com.gqx.ChooseTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//���otherwise���� 
public class Otherwise extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		//�Ӹ���ǩ�л�ȡWhen�жϵĽ��
		Choose parent=(Choose)this.getParent();
		Boolean test=parent.isFlag();
		if (!test) {
			this.getJspBody().invoke(null);
		}
		
	}
}
