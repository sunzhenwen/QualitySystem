package com.tj.jst.outside.staffmanage.positions.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.staffmanage.positions.condition.PositionsCondition;
import com.tj.jst.outside.staffmanage.positions.model.Positions;
import com.tj.jst.outside.staffmanage.positions.service.IPositionsService;
import com.tj.jst.outside.staffmanage.positions.service.PositionsServiceImpl;

/**
 * ��λ��Ա
 * @author Administrator
 *
 */
public class PositionsAction extends BaseAction {
	
	//��λ��Ա����
	private String personId;
	//��λ��Ա
	private Positions positions;
	//��λ��Աlist
	private List<Positions> positionsList;
	//��ʾ��Ϣ
	private String message;
	
	private PositionsCondition condition = new PositionsCondition();
	
	public void setCondition(PositionsCondition condition) {
		this.condition = condition;
	}

	public PositionsCondition getCondition() {
		PositionsCondition sessionCondition = (PositionsCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IPositionsService staffService = new PositionsServiceImpl();
		String userName = (String)this.get("userName");
		this.getCondition().setCorpName(userName);
		//��ҳ��ѯ
		currentPage = staffService.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "positionsSuccess";
	}
	
	/**
	 * ����
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Positions> getPositionsList() {
		return positionsList;
	}

	public void setPositionsList(List<Positions> positionsList) {
		this.positionsList = positionsList;
	}

	public Positions getPositions() {
		return positions;
	}

	public void setPositions(Positions positions) {
		this.positions = positions;
	}

}
