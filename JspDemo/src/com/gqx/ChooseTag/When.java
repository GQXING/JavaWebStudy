package com.gqx.ChooseTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//When��ǩ��Ҫ���ж�
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
		//��Ϊchoose��ǩ������һ���ӱ�ǩothsewhise��Ҫ���жϣ�
		//��otherwiseû�����ԣ���Ҫͨ������ǩ�����жϵĽ��,
		//����������ڸ���ǩ�е�flag�С�
		//��ȡ����ǩ
		Choose parent=(Choose)this.getParent();
		parent.setFlag(test);
	}
}
