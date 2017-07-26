package com.tj.jst.outside.businessReport.queryQualificationInfo.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryQualificationInfo.condition.QualificationInfoCondition;
import com.tj.jst.outside.businessReport.queryQualificationInfo.model.QualificationInfo;
import com.tj.jst.outside.businessReport.queryQualificationInfo.service.IQueryQualificationInfoService;
import com.tj.jst.outside.businessReport.queryQualificationInfo.service.QueryQualificationInfoServiceImpl;

/**
 * 企业所上报资质状态查询
 * @author DarkFlameMaster
 *
 */
public class QueryQualificationInfoAction extends BaseAction {

	private String message = "";					//提示信息
	private String NewQualId;						//企业资质ID
	private QualificationInfo Qualification;		//资质信息查询
	private List<DictionaryClass> CretLevelNums;     //资质资格类型
	
	private QualificationInfoCondition condition = new QualificationInfoCondition();
	
	public void setCondition(QualificationInfoCondition condition) {
		this.condition = condition;
	}
	
	public QualificationInfoCondition getCondition() {
		QualificationInfoCondition sessionCondition = (QualificationInfoCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 跳转到企业资质信息页面；
	 * 
	 * @return
	 */
	public String queryQualificationInfoPage() {
		
		IQueryQualificationInfoService staffservice = new QueryQualificationInfoServiceImpl();
		this.getCondition().setCorpId((String)this.get("corpCode"));
		// 分页查询
		currentPage = staffservice.queryCertifiedService(this.getCondition());
		// 资质资格类型查询
		CretLevelNums = staffservice.CretLevelNums();
		this.set(getActionName(), condition);
		return "queryApplicationPage";
	}
	
	/**
	 * 企业所申请资质信息审批状态详细页面
	 * 
	 * @return
	 */
	public String queryQualification() {
		IQueryQualificationInfoService staffservice = new QueryQualificationInfoServiceImpl();
		Qualification = staffservice.queryById(NewQualId);
		return "queryApplicationListPage";
	}
	
	/**
	 * 企业申请资质信息删除
	 */
	public String deleteQualification(){
		IQueryQualificationInfoService staffservice = new QueryQualificationInfoServiceImpl();
		message = staffservice.deleteById(NewQualId);
		// 分页查询
		currentPage = staffservice.queryCertifiedService(this.getCondition());
		// 资质资格类型查询
		CretLevelNums = staffservice.CretLevelNums();
		this.set(getActionName(), condition);
		return "queryApplicationPage";
	}
	
	/**
	 * 返回业务办理界面
	 * 
	 * @return
	 */
	public String goBack() {
		return "goBusiness";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNewQualId() {
		return NewQualId;
	}

	public void setNewQualId(String newQualId) {
		NewQualId = newQualId;
	}

	public QualificationInfo getQualification() {
		return Qualification;
	}

	public void setQualification(QualificationInfo qualification) {
		Qualification = qualification;
	}

	public List<DictionaryClass> getCretLevelNums() {
		return CretLevelNums;
	}

	public void setCretLevelNums(List<DictionaryClass> cretLevelNums) {
		CretLevelNums = cretLevelNums;
	}

	
	
}
