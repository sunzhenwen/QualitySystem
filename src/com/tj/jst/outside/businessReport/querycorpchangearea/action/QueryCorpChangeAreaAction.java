package com.tj.jst.outside.businessReport.querycorpchangearea.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;
import com.tj.jst.outside.businessReport.querycorpchangearea.condition.QueryCorpChangeAreaCondition;
import com.tj.jst.outside.businessReport.querycorpchangearea.service.IQueryCorpChangeAreaService;
import com.tj.jst.outside.businessReport.querycorpchangearea.service.QueryCorpChangeAreaServiceImpl;

public class QueryCorpChangeAreaAction extends BaseAction {

	private String corpName;// 查询主键
	private ChangeArea change;// model类
	private String message;// 返回消息
	private String changeId;// 主键

	private QueryCorpChangeAreaCondition condition = new QueryCorpChangeAreaCondition();

	public void setCondition(QueryCorpChangeAreaCondition condition) {
		this.condition = condition;
	}

	public QueryCorpChangeAreaCondition getCondition() {
		QueryCorpChangeAreaCondition sessionCondition = (QueryCorpChangeAreaCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 查询页面
	 * 
	 * @return
	 */
	public String queryPage() {
		IQueryCorpChangeAreaService service = new QueryCorpChangeAreaServiceImpl();
		String userName = (String)this.get("userName");
		this.getCondition().setCorpName(userName);
		currentPage = service.queryPage(this.getCondition());
		return "queryPage";
	}

	/**
	 * 删除归属地变更条目
	 * 
	 * @return
	 */
	public String deleteChange() {
		IQueryCorpChangeAreaService service = new QueryCorpChangeAreaServiceImpl();
		message = service.deleteChange(changeId);
		return "query";
	}

	/**
	 * 返回操作页面
	 * 
	 * @return
	 */
	public String goBack() {
		return "business";
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public ChangeArea getChange() {
		return change;
	}

	public void setChange(ChangeArea change) {
		this.change = change;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}

}
