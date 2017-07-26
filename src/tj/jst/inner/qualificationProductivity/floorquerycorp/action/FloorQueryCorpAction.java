package com.tj.jst.inner.qualificationProductivity.floorquerycorp.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.floorapproval.condition.FloorQueryCorpCondition;
import com.tj.jst.inner.qualificationProductivity.floorapproval.service.FloorQueryCorpServiceImpl;
import com.tj.jst.inner.qualificationProductivity.floorapproval.service.IFloorQueryCorpService;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 大厅查询企业信息方法
 * 
 * @author Administrator
 *
 */
public class FloorQueryCorpAction extends BaseAction {

	private Corp corp;// 企业信息model类F

	private String corpCode;// 企业组织机构代码证

	private FloorQueryCorpCondition condition = new FloorQueryCorpCondition();// 分页类

	public void setCondition(FloorQueryCorpCondition condition) {
		this.condition = condition;
	}

	public FloorQueryCorpCondition getCondition() {
		FloorQueryCorpCondition sessionCondition = (FloorQueryCorpCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 分页类
	 * 
	 * @return
	 */
	public String queryPage() {
		IFloorQueryCorpService service = new FloorQueryCorpServiceImpl();
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 查询企业相信信息
	 * 
	 * @return
	 */
	public String queryInfo() {
		IFloorQueryCorpService service = new FloorQueryCorpServiceImpl();
		corp = service.queryInfo(corpCode);
		return "queryInfo";
	}

	/**
	 * 返回
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public Corp getCorp() {
		return corp;
	}

	public void setCorp(Corp corp) {
		this.corp = corp;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
