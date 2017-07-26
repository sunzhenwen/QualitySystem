package com.tj.jst.inner.qualificationProductivity.querySeparateQualification.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.IProvinceApprovalService;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.ProvinceApprovalServiceImpl;
import com.tj.jst.inner.qualificationProductivity.querySeparateQualification.condition.QuerySeparateQualificationCondition;
import com.tj.jst.inner.qualificationProductivity.querySeparateQualification.service.IQuerySeparateQualificationService;
import com.tj.jst.inner.qualificationProductivity.querySeparateQualification.service.QuerySeparateQualificationServiceImpl;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ȫ����Ϣ��ѯ
 * 
 * @author DarkFlameMaster
 *
 */
public class QuerySeparateQualificationAction extends BaseAction {

	// ����
	private String newQualId;
	NewQualification newQualification;
	NewQualification oldQualification;
	// ְ����Ա����
	private int countTitle;
	// ע�Ὠ��ʦ����
	private int countConstructor;
	// ��λ��Ա
	private int countPositions;
	// ������������
	private int countSkilledworker;

	// ���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	private List<DictionaryClass> cretLevels;
	// ��������(�ֵ��TBADDTYPEDIC)
	private List<DictionaryClass> addTypeNums;
	// ��־
	private String mark;

	private QuerySeparateQualificationCondition condition = new QuerySeparateQualificationCondition();

	public void setCondition(QuerySeparateQualificationCondition condition) {
		this.condition = condition;
	}

	public QuerySeparateQualificationCondition getCondition() {
		QuerySeparateQualificationCondition sessionCondition = (QuerySeparateQualificationCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ҳ��ѯ
	 */
	public String queryPage() {
		IQuerySeparateQualificationService allService = new QuerySeparateQualificationServiceImpl();
		// ��ҳ��ѯ
		currentPage = allService.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת��ѯҳ��
	 */
	public String infoPage() {
		IQuerySeparateQualificationService allService = new QuerySeparateQualificationServiceImpl();
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		newQualification = allService.queryapproval(newQualId);
		// ��ѯְ����Ա����
		countTitle = provinceApprovalService.queryCountTitle(newQualification
				.getCorpId());
		// ע�Ὠ��ʦ����
		countConstructor = provinceApprovalService
				.queryCountConstructor(newQualification.getCorpName());
		// ��λ��Ա
		countPositions = provinceApprovalService
				.queryCountPositions(newQualification.getCorpName());
		// ��ѯ������������
		countSkilledworker = provinceApprovalService
				.queryCountSkilledworker(newQualification.getCorpId());

		mark = allService.queryUpdate(newQualId);
		if (mark.equals("����")) {
			oldQualification = allService.queryOldInfo(
					newQualification.getCorpId(),
					newQualification.getSpecialtyType(),
					newQualification.getCretLevel() - 1);
			return "infoUpdatePage";
		} else {
			return "infoPage";
		}

	}

	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionaryClass() {
		IQuerySeparateQualificationService allService = new QuerySeparateQualificationServiceImpl();
		// ���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
		cretLevels = allService.queryCretLevels();
		// ��������(�ֵ��TBADDTYPEDIC)
		addTypeNums = allService.queryAddTypeNums();
	}

	/**
	 * ����
	 * 
	 * @return
	 */
	public String goBack() {
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

	public int getCountTitle() {
		return countTitle;
	}

	public void setCountTitle(int countTitle) {
		this.countTitle = countTitle;
	}

	public int getCountConstructor() {
		return countConstructor;
	}

	public void setCountConstructor(int countConstructor) {
		this.countConstructor = countConstructor;
	}

	public int getCountPositions() {
		return countPositions;
	}

	public void setCountPositions(int countPositions) {
		this.countPositions = countPositions;
	}

	public int getCountSkilledworker() {
		return countSkilledworker;
	}

	public void setCountSkilledworker(int countSkilledworker) {
		this.countSkilledworker = countSkilledworker;
	}

}
