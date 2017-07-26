package com.tj.jst.login.action;

import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.login.service.ILoginService;
import com.tj.jst.login.service.LoginServiceImpl;
import com.tj.jst.outside.businessReport.qualitychange.service.QualityChangeService;
import com.tj.jst.outside.businessReport.qualitychange.service.QualityChangeServiceImpl;

/**
 * ��½
 * @author Administrator
 *
 */
public class LoginAction extends BaseAction {
	
	private String results;
	
	//ϵͳ������ӭҳ���Զ�����˷���
	public String login()throws Exception{
    	return "login";
    }
	
	public String deptLogin()throws Exception{
    	return "deptLogin";
    }
	
	/**
	 * ��ת��֤ҳ��
	 * @return
	 */
	public String checkOne()
	{
		
		return "checkOne";
	}
	
	/**
	 * �жϲ�ѯҳ��
	 * @return
	 */
	public String businessPage()
	{
		Login login = null;
		ILoginService loginService = new LoginServiceImpl();
		login = loginService.query(results);
		String page = "";
		
		//���Ϊ��ҵ�û�
		if(login.getUserId() != null)
		{
			
			this.set("login", login);
			this.set("corpId",login.getUserId());
			this.set("userName", login.getUserName());
			this.set("corpCode", login.getCorpCode());
			page = "businessPage";
		}
		
		//�ж��Ƿ�Ϊ��ҵ�û�,���Ϊnull,��½��Ϊ�����û�
		if(login.getUserId()==null)
		{
			//�����Ա��Ϣ
	    	List<String> list= new ArrayList<String>();
	    	QualityChangeService qualityChangeService=new QualityChangeServiceImpl();
	    	list= loginService.getRole(results, "1");
	    	login = new Login();
	    	if(list.get(0)!=null && !list.get(0).equals(""))
	    	{
	    		//����
	    		login.setLoginuserid(list.get(0));
	    		//����
	    		login.setName(list.get(1));
	    		this.set("name", list.get(1));
	    		//��ɫId
	    		login.setRoleID(list.get(2));
	    		//����Id
	    		login.setDepartmentID(list.get(3));
	    		this.set("departmentID", list.get(3));
	    		//Ȩ�޼���
	    		login.setPopedomid(list.get(4));
	    		//��������
	    		login.setDepartment(list.get(5));
	    		//��Աid
	    		login.setPersonalID(list.get(6));
	    		this.set("personalID", list.get(6));
	    		//��ɫ����
	    		login.setRolename(list.get(7));
	    		//System.out.println("userid:"+list.get(6));
	    		this.set("checkType", qualityChangeService.getCheckType(list.get(6)));
	    		this.set("login", login);
	    		if(login.getRolename().equals("-98")) {
	    			page = "nameSearchPage";
	    		} else {
	    			page = "deptPage";
	    		}
				
	    	}else
	    	{
	    		page = "login";
	    	}
	    	
		}
		return page;
	}

	/**
	 * ��ת��װ����˵��ҳ��
	 * @return
	 */
	public String driveInstructions()
	{
		return "driveInstructions";
	}
	
	/**
	 * �˳�ϵͳ
	 */
	public String exitSystem()
	{
		this.clearSession();
		return "login";
	}
	
	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

}
