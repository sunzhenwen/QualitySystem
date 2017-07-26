package com.tj.jst.inner.qualificationProductivity.twoQuery.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.twoQuery.condition.TwoQueryCondition;
import com.tj.jst.inner.qualificationProductivity.twoQuery.service.ITwoQueryService;
import com.tj.jst.inner.qualificationProductivity.twoQuery.service.TwoQueryServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 初审审批历史记录查询
 * @author DarkFlameMaster
 *
 */
public class TwoQueryAction extends BaseAction{

	//主键
	private String newQualId;
	NewQualification newQualification;
	//资质等级(字典表：TBCERTTITLELEVELDIC)
	private List<DictionaryClass> cretLevels;
	//申请类型(字典表：TBADDTYPEDIC)
	private List<DictionaryClass> addTypeNums;
	//当前审批人员
	private String approvalStaff;
	//审批人员Id
	private String approvalStaffId;
	
	
	private TwoQueryCondition condition = new TwoQueryCondition();
	
	public void setCondition(TwoQueryCondition condition) {
		this.condition = condition;
	}
	
	public TwoQueryCondition getCondition(){
		TwoQueryCondition sessionCondition = (TwoQueryCondition) get(getActionName());;
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 分页查询
	 */
	public String queryPage(){
		ITwoQueryService twoQueryService = new TwoQueryServiceImpl();
		String personalID = (String)this.get("personalID");
		this.getCondition().setApprovalStaffId(personalID);
		currentPage = twoQueryService.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), this.getCondition());
		return "queryPage";
	}
	
	/**
	 * 跳转查询页面
	 */
	public String infoPage(){
		ITwoQueryService twoQueryService = new TwoQueryServiceImpl();
		Login login = (Login)this.get("login");
		newQualification = twoQueryService.queryapproval(newQualId);
		return "infoPage";
		
	}
	
	/**
	 * 查询字典表
	 */
	public void queryDictionaryClass()
	{
		ITwoQueryService twoQueryService = new TwoQueryServiceImpl();
		//资质等级(字典表：TBCERTTITLELEVELDIC)
		cretLevels = twoQueryService.queryCretLevels();
		//申请类型(字典表：TBADDTYPEDIC)
		addTypeNums = twoQueryService.queryAddTypeNums();
	}
	
	/**
	 * 返回
	 * @return
	 */
	public String goBack()
	{
		return "query";
	}

	public String getNewQualId() {
		return newQualId;
	}

	public void setNewQualId(String newQualId) {
		this.newQualId = newQualId;
	}

	public NewQualification getNewQualification() {
		return newQualification;
	}

	public void setNewQualification(NewQualification newQualification) {
		this.newQualification = newQualification;
	}

	public List<DictionaryClass> getCretLevels() {
		return cretLevels;
	}

	public void setCretLevels(List<DictionaryClass> cretLevels) {
		this.cretLevels = cretLevels;
	}

	public List<DictionaryClass> getAddTypeNums() {
		return addTypeNums;
	}

	public void setAddTypeNums(List<DictionaryClass> addTypeNums) {
		this.addTypeNums = addTypeNums;
	}

	public String getApprovalStaff() {
		return approvalStaff;
	}

	public void setApprovalStaff(String approvalStaff) {
		this.approvalStaff = approvalStaff;
	}

	public String getApprovalStaffId() {
		return approvalStaffId;
	}

	public void setApprovalStaffId(String approvalStaffId) {
		this.approvalStaffId = approvalStaffId;
	}
	
	
	
}
