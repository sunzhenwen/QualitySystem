package com.tj.jst.inner.qualificationProductivity.queryapplicationhistory.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.queryapplicationhistory.condition.QueryApplicationHistoryCondition;
import com.tj.jst.inner.qualificationProductivity.queryapplicationhistory.service.IQueryApplicationHistroyService;
import com.tj.jst.inner.qualificationProductivity.queryapplicationhistory.service.QueryApplicationHistoryServiceImpl;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ��ʷ������ѯ
 * @author DarkFlameMaster
 *
 */
public class QueryApplicationHistoryAction extends BaseAction{

	//����
	private String newQualId;
	NewQualification newQualification;
	NewQualification oldQualification;
	//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	private List<DictionaryClass> cretLevels;
	//��������(�ֵ��TBADDTYPEDIC)
	private List<DictionaryClass> addTypeNums;
	// �Ƿ������������ж�
	private String mark;
	
	private QueryApplicationHistoryCondition condition = new QueryApplicationHistoryCondition();
	
	public void setCondition(QueryApplicationHistoryCondition condition) {
		this.condition = condition;
	}
	
	public QueryApplicationHistoryCondition getCondition(){
		QueryApplicationHistoryCondition sessionCondition = (QueryApplicationHistoryCondition) get(getActionName());
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
		IQueryApplicationHistroyService historyService = new QueryApplicationHistoryServiceImpl();
		String personalID = (String)this.get("personalID");
		String departmentID = (String)this.get("departmentID");
		this.getCondition().setApprovalStaffId(personalID);
		this.getCondition().setDeptId(departmentID);
		//��ҳ��ѯ
		currentPage = historyService.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}
	
	/**
	 * ��ת��ѯҳ��
	 */
	public String infoPage(){
		IQueryApplicationHistroyService historyService = new QueryApplicationHistoryServiceImpl();
		mark = historyService.queryUpdate(newQualId);
		if(mark.equals("����")){
			newQualification = historyService.queryapproval(newQualId);
			oldQualification = historyService.queryOldInfo(newQualification.getCorpId(), newQualification.getSpecialtyType(), newQualification.getCretLevel() - 1 );
			return "infoUpdatePage";
		}else{
			newQualification = historyService.queryapproval(newQualId);
			return "infoPage";
		}
	}
	
	
	
	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionaryClass()
	{
		IQueryApplicationHistroyService historyService = new QueryApplicationHistoryServiceImpl();
		//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
		cretLevels = historyService.queryCretLevels();
		//��������(�ֵ��TBADDTYPEDIC)
		addTypeNums = historyService.queryAddTypeNums();
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

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public NewQualification getOldQualification() {
		return oldQualification;
	}

	public void setOldQualification(NewQualification oldQualification) {
		this.oldQualification = oldQualification;
	}
	
}
