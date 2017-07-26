package com.tj.jst.inner.qualificationProductivity.provinceApproval.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.QueryConstructorCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.IProvinceApprovalService;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.ProvinceApprovalServiceImpl;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * ��ѯע�Ὠ��ʦ
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class QueryConstructorAction extends BaseAction {
	
	//ע�Ὠ��ʦlist
	private List<Constructor> constructors;
	
	private QueryConstructorCondition condition = new QueryConstructorCondition();
	
	public void setCondition(QueryConstructorCondition condition) {
		this.condition = condition;
	}

	public QueryConstructorCondition getCondition() {
		QueryConstructorCondition sessionCondition = (QueryConstructorCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * ע�Ὠ��ʦ��ѯ
	 * @return
	 */
	public String getConstructor()
	{
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		currentPage = provinceApprovalService.queryConstructor(this.getCondition());
		this.set(getActionName(), condition);
		return "getConstructor";
	}
	
	public List<Constructor> getConstructors() {
		return constructors;
	}

	public void setConstructors(List<Constructor> constructors) {
		this.constructors = constructors;
	}

}
