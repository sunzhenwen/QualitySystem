package com.tj.jst.inner.qualificationProductivity.provinceApproval.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.corpinto.performance.condition.PerformanceCondition;
import com.tj.jst.outside.corpinto.performance.model.Performance;
import com.tj.jst.outside.corpinto.performance.service.IPerformanceService;
import com.tj.jst.outside.corpinto.performance.service.PerformanceServiceImpl;

/**
 * 查询企业工程业绩
 * 
 * @author DarkFlameMaster
 *
 */
@SuppressWarnings("serial")
public class QueryPerformanceAction extends BaseAction {
	
	private String perId;//主键
	private Performance performance;
	
	private PerformanceCondition condition = new PerformanceCondition();
	
	public void setCondition(PerformanceCondition condition) {
		this.condition = condition;
	}

	public PerformanceCondition getCondition() {
		PerformanceCondition sessionCondition = (PerformanceCondition) get(getActionName());
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
		IPerformanceService service = new PerformanceServiceImpl();
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "getPerformance";
	}

	public String getPerId() {
		return perId;
	}

	public void setPerId(String perId) {
		this.perId = perId;
	}

	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

}
