package com.tj.jst.inner.qualificationProductivity.queryCorp.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.queryCorp.condition.QueryCorpApplyCondition;
import com.tj.jst.inner.qualificationProductivity.queryCorp.service.IQueryCorpApplyService;
import com.tj.jst.inner.qualificationProductivity.queryCorp.service.QueryCorpApplyServiceImpl;

/**
 * 查询企业所申报的资质信息方法
 * 
 * @author Administrator
 *
 */
public class QueryCorpApplyAction extends BaseAction {

	private String corpCode;// 企业组织机构代码证
	private String message;// 返回信息

	private QueryCorpApplyCondition condition = new QueryCorpApplyCondition();

	public void setCondition(QueryCorpApplyCondition condition) {

		this.condition = condition;
	}

	public QueryCorpApplyCondition getCondition() {
		QueryCorpApplyCondition sessionCondition = (QueryCorpApplyCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 分页查看
	 * 
	 * @return
	 */
	public String queryPage() {
		IQueryCorpApplyService service = new QueryCorpApplyServiceImpl();
		condition.setCorpCode(corpCode);
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
