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
		//�õ���ǰҳ���pagecontex�������ں���Ĳ����н�ֵ�����������
		PageContext context=(PageContext) this.getJspContext();
		//����ֻ�ж�List����
		if (items instanceof List) {
			List list=(List)items;
			for (Object object : list) {
				//����Ӧ��ֵ���������������������ʽ�ķ�ʽ���
				//������${student.name } - ����:${student.age }
				context.setAttribute(var, object);
				//�����ҳ����ȥ
				this.getJspBody().invoke(null);
			}
		}
		
		//Map
				if(items instanceof Map){
					Map map = (Map)items;
					Set<Entry> entrySet = map.entrySet();
					for(Entry entry :entrySet){
						//��ÿ����������������(pageContext)
						context.setAttribute(var, entry);
						//��ʾ��ǩ������
						this.getJspBody().invoke(null);
					}
				}
		
	}
}
