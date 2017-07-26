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
 * 登陆
 * @author Administrator
 *
 */
public class LoginAction extends BaseAction {
	
	private String results;
	
	//系统启动欢迎页面自动进入此方法
	public String login()throws Exception{
    	return "login";
    }
	
	public String deptLogin()throws Exception{
    	return "deptLogin";
    }
	
	/**
	 * 跳转认证页面
	 * @return
	 */
	public String checkOne()
	{
		
		return "checkOne";
	}
	
	/**
	 * 判断查询页面
	 * @return
	 */
	public String businessPage()
	{
		Login login = null;
		ILoginService loginService = new LoginServiceImpl();
		login = loginService.query(results);
		String page = "";
		
		//如果为企业用户
		if(login.getUserId() != null)
		{
			
			this.set("login", login);
			this.set("corpId",login.getUserId());
			this.set("userName", login.getUserName());
			this.set("corpCode", login.getCorpCode());
			page = "businessPage";
		}
		
		//判断是否为企业用户,如果为null,登陆的为部门用户
		if(login.getUserId()==null)
		{
			//获得人员信息
	    	List<String> list= new ArrayList<String>();
	    	QualityChangeService qualityChangeService=new QualityChangeServiceImpl();
	    	list= loginService.getRole(results, "1");
	    	login = new Login();
	    	if(list.get(0)!=null && !list.get(0).equals(""))
	    	{
	    		//主键
	    		login.setLoginuserid(list.get(0));
	    		//人名
	    		login.setName(list.get(1));
	    		this.set("name", list.get(1));
	    		//角色Id
	    		login.setRoleID(list.get(2));
	    		//部门Id
	    		login.setDepartmentID(list.get(3));
	    		this.set("departmentID", list.get(3));
	    		//权限集合
	    		login.setPopedomid(list.get(4));
	    		//部门名称
	    		login.setDepartment(list.get(5));
	    		//人员id
	    		login.setPersonalID(list.get(6));
	    		this.set("personalID", list.get(6));
	    		//角色名称
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
	 * 跳转安装驱动说明页面
	 * @return
	 */
	public String driveInstructions()
	{
		return "driveInstructions";
	}
	
	/**
	 * 退出系统
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
