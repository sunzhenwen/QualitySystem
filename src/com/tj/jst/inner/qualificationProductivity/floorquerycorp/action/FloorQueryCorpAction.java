package com.tj.jst.inner.qualificationProductivity.floorquerycorp.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.floorapproval.condition.FloorQueryCorpCondition;
import com.tj.jst.inner.qualificationProductivity.floorapproval.service.FloorQueryCorpServiceImpl;
import com.tj.jst.inner.qualificationProductivity.floorapproval.service.IFloorQueryCorpService;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ������ѯ��ҵ��Ϣ����
 * 
 * @author Administrator
 *
 */
public class FloorQueryCorpAction extends BaseAction {

	private Corp corp;// ��ҵ��Ϣmodel��F

	private String corpCode;// ��ҵ��֯��������֤

	private FloorQueryCorpCondition condition = new FloorQueryCorpCondition();// ��ҳ��

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
	 * ��ҳ��
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
	 * ��ѯ��ҵ������Ϣ
	 * 
	 * @return
	 */
	public String queryInfo() {
		IFloorQueryCorpService service = new FloorQueryCorpServiceImpl();
		corp = service.queryInfo(corpCode);
		return "queryInfo";
	}

	/**
	 * ����
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
