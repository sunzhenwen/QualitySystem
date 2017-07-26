package com.tj.jst.inner.qualificationProductivity.provinceApproval.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.IProvinceApprovalService;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.ProvinceApprovalServiceImpl;
import com.tj.jst.outside.staffmanage.title.condition.TitleCondition;

/**
 * ��ѯע�Ἴ��������Ա
 * 
 * @author DarkFlameMaster
 *
 */
@SuppressWarnings("serial")
public class QueryTitleAction extends BaseAction {
	
	private TitleCondition condition = new TitleCondition();

	public void setCondition(TitleCondition condition) {
		this.condition = condition;
	}

	public TitleCondition getCondition() {
		TitleCondition sessionCondition = (TitleCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public String getTitle()
	{
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		currentPage = provinceApprovalService.queryTitle(this.getCondition());
		this.set(getActionName(), condition);
		return "getSkilledworker";
	}

}
