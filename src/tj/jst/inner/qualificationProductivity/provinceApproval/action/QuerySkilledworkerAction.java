package com.tj.jst.inner.qualificationProductivity.provinceApproval.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.QuerySkilledworkerCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.IProvinceApprovalService;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.ProvinceApprovalServiceImpl;

/**
 * 查询注册技术工种人员
 * 
 * @author DarkFlameMaster
 *
 */
@SuppressWarnings("serial")
public class QuerySkilledworkerAction extends BaseAction {
	
	private QuerySkilledworkerCondition condition = new QuerySkilledworkerCondition();

	public void setCondition(QuerySkilledworkerCondition condition) {
		this.condition = condition;
	}

	public QuerySkilledworkerCondition getCondition() {
		QuerySkilledworkerCondition sessionCondition = (QuerySkilledworkerCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 查询技术工种
	 * @return
	 */
	public String getSkilledworker()
	{
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		currentPage = provinceApprovalService.querySkilledworker(this.getCondition());
		this.set(getActionName(), condition);
		return "getSkilledworker";
	}

}
