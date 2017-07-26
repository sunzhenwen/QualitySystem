package com.tj.jst.inner.qualificationProductivity.querychangeinfo.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;
import com.tj.jst.inner.qualificationProductivity.changearea.service.ChangeAreaServiceImpl;
import com.tj.jst.inner.qualificationProductivity.changearea.service.IChangeAreaService;
import com.tj.jst.inner.qualificationProductivity.querychangeinfo.condition.QueryChangeInfoCondition;
import com.tj.jst.inner.qualificationProductivity.querychangeinfo.service.IQueryChangeInfoService;
import com.tj.jst.inner.qualificationProductivity.querychangeinfo.service.QueryChangeInfoServiceImpl;

public class QueryChangeInfoAction extends BaseAction {

	private String corpName;// 查询主键
	private ChangeArea change;// model类
	private String message;// 返回消息
	private String changeId;// 主键
	private String provinceName;// 省名称
	private String cityName;// 城市名

	private QueryChangeInfoCondition condition = new QueryChangeInfoCondition();

	public void setCondition(QueryChangeInfoCondition condition) {
		this.condition = condition;
	}

	public QueryChangeInfoCondition getCondition() {
		QueryChangeInfoCondition sessionCondition = (QueryChangeInfoCondition) get(getActionName());
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
		IQueryChangeInfoService service = new QueryChangeInfoServiceImpl();
		String departmentID = (String)this.get("departmentID");
		this.getCondition().setDeptId(departmentID);
		currentPage = service.queryPage(this.getCondition());
		this.set(getActionName(), this.getCondition());
		return "queryPage";
	}

	/**
	 * 查询详细界面
	 * 
	 * @return
	 */
	public String queryInfo() {
		IQueryChangeInfoService service = new QueryChangeInfoServiceImpl();
		IChangeAreaService ss = new ChangeAreaServiceImpl();
		change = service.queryInfo(changeId);
		if(change.getAfterProvinceArea() != null){
			provinceName = ss.queryCityName(change.getAfterProvinceArea().trim());
		}
		if(change.getAfterCityArea() != null){
			cityName = ss.queryCityName(change.getAfterCityArea().trim());
		}
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

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
