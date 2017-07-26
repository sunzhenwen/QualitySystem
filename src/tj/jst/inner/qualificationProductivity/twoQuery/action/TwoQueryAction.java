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
 * ����������ʷ��¼��ѯ
 * @author DarkFlameMaster
 *
 */
public class TwoQueryAction extends BaseAction{

	//����
	private String newQualId;
	NewQualification newQualification;
	//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	private List<DictionaryClass> cretLevels;
	//��������(�ֵ��TBADDTYPEDIC)
	private List<DictionaryClass> addTypeNums;
	//��ǰ������Ա
	private String approvalStaff;
	//������ԱId
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
	 * ��ҳ��ѯ
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
	 * ��ת��ѯҳ��
	 */
	public String infoPage(){
		ITwoQueryService twoQueryService = new TwoQueryServiceImpl();
		Login login = (Login)this.get("login");
		newQualification = twoQueryService.queryapproval(newQualId);
		return "infoPage";
		
	}
	
	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionaryClass()
	{
		ITwoQueryService twoQueryService = new TwoQueryServiceImpl();
		//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
		cretLevels = twoQueryService.queryCretLevels();
		//��������(�ֵ��TBADDTYPEDIC)
		addTypeNums = twoQueryService.queryAddTypeNums();
	}
	
	/**
	 * ����
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
