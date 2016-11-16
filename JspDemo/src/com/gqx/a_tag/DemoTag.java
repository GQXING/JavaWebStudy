package com.gqx.a_tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DemoTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
			System.out.println("��ǩִ����");
			/**
			 * ���Ʊ�ǩ�Ƿ����
			 */
			//1��1�õ���ǩ�������
			JspFragment jspBody=this.getJspBody();
			//ִ��invoke��������ѱ�ǩ�����������ָ����Writer������
			//JspWriter out=this.getJspContext().getOut();
			//�����ǩ������	//���������ǩ������ݿ��Բ�ȥ������
			//jspBody.invoke(out);
			/**Դ�ĵ�
			 * invoke(java.io.Writer out)Executes the fragment and directs all output to the given Writer, 
			 *  or the JspWriter returned by the getOut() method of the JspContext associated with the fragment if out is null.
			 *  Ĭ�Ͽ�ֱ����������������
			 */
			//jspBody.invoke(null);
			
			
			/**
			 * 2�����Ʊ�ǩ���������Ƿ����
			 * Ĭ���������
			 * ��������׳�SkipPageException�쳣
			 */
			//throw new SkipPageException();
			
			/**
			 *3���ظ������ǩ������,ִ�ж��invoke����
			 */
			for (int i = 0; i < 5; i++) {
				jspBody.invoke(null);
			}
			
			/**
			 * 4/�ı��ǰ�������
			 */
			//StringWrite��ʱ�����������ַ�������ʽ���ظû������ĵ�ǰֵ��
			StringWriter sw=new StringWriter();
			//����ǩ�����ݷ��뵽��ʱ������
			jspBody.invoke(sw);
			//����ʱ�����õ���ǩ�������
			String content=sw.toString();
			//�ı��ǩ�������
			content=content.toLowerCase();
			//�ѱ�ǩ����������������
			//����ʹ��jspBody.invoke(null);��ΪjspBody������û�иı�
			this.getJspContext().getOut().write(content);
	}
}
