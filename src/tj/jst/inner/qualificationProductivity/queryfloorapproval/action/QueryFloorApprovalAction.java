package com.tj.jst.inner.qualificationProductivity.queryfloorapproval.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;
import com.tj.jst.inner.qualificationProductivity.queryfloorapproval.condition.QueryFloorApprovalCondition;
import com.tj.jst.inner.qualificationProductivity.queryfloorapproval.service.IQueryFloorApprovalService;
import com.tj.jst.inner.qualificationProductivity.queryfloorapproval.service.QueryFloorApprovalServiceImpl;

/**
 * ��ʷ���������ѯ����
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryFloorApprovalAction extends BaseAction {

	private FloorApproval floor;// Model��
	private String id;// ��ѯ����
	private String message;// ������Ϣ

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
	 * ��ҳ��ѯ
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
	 * �鿴��ϸ
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
	 * ����
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
