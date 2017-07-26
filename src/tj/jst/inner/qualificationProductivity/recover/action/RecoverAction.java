package com.tj.jst.inner.qualificationProductivity.recover.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.recover.condition.RecoverCondition;
import com.tj.jst.inner.qualificationProductivity.recover.service.IRecoverService;
import com.tj.jst.inner.qualificationProductivity.recover.service.RecoverServiceImpl;
import com.tj.jst.login.model.Login;

/**
 * ��ҵ���ʻָ�
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class RecoverAction extends BaseAction {
	
	private String[] ids;
	private List<DictionaryClass> econmicNums; //��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IRecoverService service = new RecoverServiceImpl();
		String departmentID = (String)this.get("departmentID");
		String personalID = (String)this.get("personalID");
		this.getCondition().setDeptId(departmentID);
		this.getCondition().setPersonalID(personalID);
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * �����ָ�
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
	 * ��ѯ�ֵ��
	 */
	public void queryDictionaryClass()
	{
		IRecoverService certifiedService = new RecoverServiceImpl();
		//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
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
