package com.tj.jst.outside.businessReport.qualitychange.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.businessReport.qualitychange.condition.QualityChangeQueryCondition;
import com.tj.jst.outside.businessReport.qualitychange.service.QualityChangeService;
import com.tj.jst.outside.businessReport.qualitychange.service.QualityChangeServiceImpl;

/**
 * 企业资质变更
 * @author Libs
 *
 */

public class QueryQualityChangeAction extends BaseAction 
{
	
	private QualityChangeQueryCondition condition = new QualityChangeQueryCondition(
			(String)this.get("checkType"),(String)this.get("departmentID")
			);

	public void setCondition(QualityChangeQueryCondition condition) {
		this.condition = condition;
	}

	public QualityChangeQueryCondition getCondition() {
		QualityChangeQueryCondition sessionCondition = (QualityChangeQueryCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}
	

	public String showQualityChangeQueryInner(){
		QualityChangeService qualityChangeService=new QualityChangeServiceImpl(); 

		currentPage = qualityChangeService.selectQualityChange(this.getCondition());
		this.set(getActionName(), condition);
			
		//qualityChangeList=qualityChangeService.selectQualityChange(login.getName());
		return "showQualityChangeQueryInner";
    }
	
	
	

}
