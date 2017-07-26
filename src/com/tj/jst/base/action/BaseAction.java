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
 * 基础action类
 * @author hhc
 *
 */

public class BaseAction extends ActionSupport implements Preparable,
ServletRequestAware,ServletResponseAware {

	private static final long serialVersionUID = 1L;
	// 获取request对象 
	HttpServletRequest request;
	// 获取response对象
	HttpServletResponse response;
	
    protected Page currentPage;
    Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public String execute() throws Exception { 
	     
		throw new BaseException("您所请求的资源不存在!!");
	}
	
	/**
	 * 获取session中对象,map形式传入key
	 * @param name
	 * @return
	 */
	protected Object get(String name) {
		return ActionContext.getContext().getSession().get(name);
	}

	/**
	 * 将对象存入session,map形式key、value
	 * @param name
	 * @param value
	 */
	protected void set(String name, Object value) {
		ActionContext.getContext().getSession().put(name, value);
	}
	
	//获取action完整路径名
	public String getActionName() {
		return this.getClass().getName();
	}
	
	//移除session中的对象
	protected void remove(Object key) {
		ActionContext.getContext().getSession().remove(key);
	}
	
	//清理session
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
