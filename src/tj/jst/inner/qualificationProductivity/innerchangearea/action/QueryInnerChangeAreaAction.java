package com.tj.jst.inner.qualificationProductivity.innerchangearea.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.condition.QueryInnerChangeAreaCondition;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.service.IInnerChangeAreaService;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.service.InnerChangeAreaServiceImpl;

public class QueryInnerChangeAreaAction extends BaseAction {

	private QueryInnerChangeAreaCondition condition = new QueryInnerChangeAreaCondition();

	public void setCondition(QueryInnerChangeAreaCondition condition) {
		this.condition = condition;
	}

	public QueryInnerChangeAreaCondition getCondition() {
		QueryInnerChangeAreaCondition sessionCondition = (QueryInnerChangeAreaCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ∑÷“≥–≈œ¢
	 * 
	 * @return
	 */
	public String queryPage() {
		IInnerChangeAreaService service = new InnerChangeAreaServiceImpl();
		currentPage = service.queryInfoPage(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}
	
	
}
