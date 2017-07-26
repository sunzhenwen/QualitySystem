package com.tj.jst.outside.businessReport.qualitychange.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.qualitychange.condition.QualityChangePageCondition;
import com.tj.jst.outside.businessReport.qualitychange.service.QualityChangeService;
import com.tj.jst.outside.businessReport.qualitychange.service.QualityChangeServiceImpl;

/**
 * 企业资质变更
 * 
 * @author Libs
 *
 */

public class QualityChangePageAction extends BaseAction {

	private QualityChangePageCondition condition = new QualityChangePageCondition(
			(String)this.get("checkType"),(String)this.get("departmentID"));

	public void setCondition(QualityChangePageCondition condition) {
		this.condition = condition;
	}

	public QualityChangePageCondition getCondition() {
		QualityChangePageCondition sessionCondition = (QualityChangePageCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	public String showQualityChangeInner() {
		QualityChangeService qualityChangeService = new QualityChangeServiceImpl();
		currentPage = qualityChangeService.queryQualityChange(this
				.getCondition());
		this.set(getActionName(), condition);

		return "showQualityChangeInner";
	}

}
