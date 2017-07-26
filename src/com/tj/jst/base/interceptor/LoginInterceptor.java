package com.tj.jst.base.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tj.jst.login.action.LoginAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.corpinto.foreign.action.ForeignCorpAction;
import com.tj.jst.outside.corpinto.notforeign.action.CorpAction;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
    public String intercept(ActionInvocation invocation) throws Exception {
 
		//ȡ�������URL
		//String url = ServletActionContext.getRequest().getRequestURL().toString();
		//��֤Session�Ƿ����
		if(!ServletActionContext.getRequest().isRequestedSessionIdValid()){
			//session����,ת��session������ʾҳ,������ת����¼ҳ��
			return "login";
		}else
		{
			/**
	         * ���˵���¼���õ�action����action����������
	         */
	        if(LoginAction.class.equals(invocation.getAction().getClass())){
	            return invocation.invoke();
	        }
	 
	        
	        if(CorpAction.class.equals(invocation.getAction().getClass())){
	            return invocation.invoke();
	        }
	        
	        if(ForeignCorpAction.class.equals(invocation.getAction().getClass())){
	            return invocation.invoke();
	        }
	        
	        /**
	         * invocationͨ��getInvocationContext�����ɻ�ȡsession
	         */
	        Login login = (Login)ServletActionContext.getRequest().getSession().getAttribute("login");
	        if(null == login){
	 
	            /**
	             * ���ص�¼ҳ��
	             */
	            return "login";
	        }
	 
	        /**
	         * �����Ϊ�ռ�������ִ��
	         */
	        return invocation.invoke();
		}
	}
}
