package com.gqx.a_tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * ��ǩ�Ĵ�������
 * @author Administrator
 *��1�����̳�SimpleTagSupport
 *��2��������doTag������doTag��û��request�ķ���������û�а취�õ�ip��ַ��
 *	Class SimpleTagSupport  Implemented Interfaces: JspTag, SimpleTag���϶�Ҫʵ������ķ���
 *SimpleTag�ķ���������setJspContext(JspContext pc) ���������������JspContext
 *����Class JspContext extended by javax.servlet.jsp.JspContext Direct Known Subclasses:PageContext
 *��JspContext��������pageContext������ͨ����̬ȥǿת
 */
public class ShowIpTag extends SimpleTagSupport{
//	private JspContext jspContext;
//	//ʵ��setJspContext����ȥ��ȡpageContext����
//	public void setJspContext(JspContext pc) {
//		this.jspContext=pc;
//	}
		@Override
		public void doTag() throws JspException, IOException {
				//��ΪjspContext��pageContext�����࣬���Կ��Խ�jspContext����ת��
			PageContext pageContext=(PageContext) this.getJspContext();
			//ͨ��pageContextȥ��ȡrequest(ͬ���ĵ���HttpServletRequest��������ServletRequest
			//Interface ServletReques All Known Subinterfaces: HttpServletRequest 
			 HttpServletRequest request= (HttpServletRequest) pageContext.getRequest();
			String ip=request.getRemoteHost();
			JspWriter writer=pageContext.getOut();
			writer.write("ʹ���Զ����ǩ��ȡip��ַ��"+ip);
		}
}
