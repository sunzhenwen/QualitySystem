package com.tj.jst.base.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.tj.jst.base.exception.BaseException;
import com.tj.jst.base.page.Page;

/**
 * ����action��
 * @author hhc
 *
 */

public class BaseAction extends ActionSupport implements Preparable,
ServletRequestAware,ServletResponseAware {

	private static final long serialVersionUID = 1L;
	// ��ȡrequest���� 
	HttpServletRequest request;
	// ��ȡresponse����
	HttpServletResponse response;
	
    protected Page currentPage;
    Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public String execute() throws Exception { 
	     
		throw new BaseException("�����������Դ������!!");
	}
	
	/**
	 * ��ȡsession�ж���,map��ʽ����key
	 * @param name
	 * @return
	 */
	protected Object get(String name) {
		return ActionContext.getContext().getSession().get(name);
	}

	/**
	 * ���������session,map��ʽkey��value
	 * @param name
	 * @param value
	 */
	protected void set(String name, Object value) {
		ActionContext.getContext().getSession().put(name, value);
	}
	
	//��ȡaction����·����
	public String getActionName() {
		return this.getClass().getName();
	}
	
	//�Ƴ�session�еĶ���
	protected void remove(Object key) {
		ActionContext.getContext().getSession().remove(key);
	}
	
	//����session
	public void clearSession() {
		ServletActionContext.getRequest().getSession().invalidate();
	}
	
	public Page getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Page currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		this.clearErrorsAndMessages();
	} 
	
}
