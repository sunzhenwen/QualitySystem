package com.tj.jst.inner.qualificationProductivity.queryfloorapproval.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;
import com.tj.jst.inner.qualificationProductivity.queryfloorapproval.condition.QueryFloorApprovalCondition;
import com.tj.jst.inner.qualificationProductivity.queryfloorapproval.service.IQueryFloorApprovalService;
import com.tj.jst.inner.qualificationProductivity.queryfloorapproval.service.QueryFloorApprovalServiceImpl;

/**
 * 历史大厅办理查询方法
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryFloorApprovalAction extends BaseAction {

	private FloorApproval floor;// Model类
	private String id;// 查询主键
	private String message;// 返回信息

	private QueryFloorApprovalCondition condition = new QueryFloorApprovalCondition();

	public void setCondition(QueryFloorApprovalCondition condition) {
		this.condition = condition;
	}

	public QueryFloorApprovalCondition getCondition() {
		QueryFloorApprovalCondition sessionCondition = (QueryFloorApprovalCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	public String queryPage() {
		IQueryFloorApprovalService service = new QueryFloorApprovalServiceImpl();
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 查看详细
	 * 
	 * @return
	 */
	public String queryInfo() {
		IQueryFloorApprovalService service = new QueryFloorApprovalServiceImpl();
		floor = service.queryInfo(id);
		if (floor.getType().equals("0")) {
			return "queryInfoOne";
		} else {
			return "queryInfoTwo";
		}
	}

	/**
	 * 返回
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public FloorApproval getFloor() {
		return floor;
	}

	public void setFloor(FloorApproval floor) {
		this.floor = floor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
