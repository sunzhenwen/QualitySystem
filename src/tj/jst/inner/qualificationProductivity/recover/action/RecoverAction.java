package com.tj.jst.inner.qualificationProductivity.recover.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.recover.condition.RecoverCondition;
import com.tj.jst.inner.qualificationProductivity.recover.service.IRecoverService;
import com.tj.jst.inner.qualificationProductivity.recover.service.RecoverServiceImpl;
import com.tj.jst.login.model.Login;

/**
 * 企业资质恢复
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class RecoverAction extends BaseAction {
	
	private String[] ids;
	private List<DictionaryClass> econmicNums; //企业登记注册类型(字典表：TBECONTYPEDIC)
	private RecoverCondition condition = new RecoverCondition();
	
	public void setCondition(RecoverCondition condition) {
		this.condition = condition;
	}

	public RecoverCondition getCondition() {
		RecoverCondition sessionCondition = (RecoverCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IRecoverService service = new RecoverServiceImpl();
		String departmentID = (String)this.get("departmentID");
		String personalID = (String)this.get("personalID");
		this.getCondition().setDeptId(departmentID);
		this.getCondition().setPersonalID(personalID);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 批量恢复
	 * @return
	 */
	public String batchRecover()
	{
		IRecoverService service = new RecoverServiceImpl();
		Login login = (Login)this.get("login");
		service.baseBatchRecover(ids,login.getPersonalID(),login.getName());
		return "query";
	}
	/**
	 * 查询字典表
	 */
	public void queryDictionaryClass()
	{
		IRecoverService certifiedService = new RecoverServiceImpl();
		//企业登记注册类型(字典表：TBECONTYPEDIC)
		econmicNums = certifiedService.queryEconmicNums();
	}
	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public List<DictionaryClass> getEconmicNums() {
		return econmicNums;
	}

	public void setEconmicNums(List<DictionaryClass> econmicNums) {
		this.econmicNums = econmicNums;
	}

}
