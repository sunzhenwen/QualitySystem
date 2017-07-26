package com.tj.jst.inner.qualificationProductivity.cityApproval.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.cityApproval.condition.CityApprovalCondition;
import com.tj.jst.inner.qualificationProductivity.cityApproval.service.CityApprovalServiceImpl;
import com.tj.jst.inner.qualificationProductivity.cityApproval.service.ICityApprovalService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ������������
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class CityApprovalAction extends BaseAction {

	// ����
	private String newQualId;
	private String[] ids;
	NewQualification newQualification;
	// ��������code
	private String cretSequenceId;
	// ��������(�ֵ��TBAPTITUDEKINDDIC)
	private List<DictionaryClass> cretTypes;
	// ���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	private List<DictionaryClass> cretLevels;
	// ��������(�ֵ��TBTRADETYPEDIC)
	private List<DictionaryClass> cretSequences;
	// ����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	private List<DictionaryClass> specialtyTypes;
	// ���ʼ���(�ֵ��TBCRETGRADEDIC)
	private List<DictionaryClass> cretGrades;
	// ��������(�ֵ��TBADDTYPEDIC)
	private List<DictionaryClass> addTypeNums;
	// ְ����Ա����
	private int countTitle;
	// ע�Ὠ��ʦ����
	private int countConstructor;
	// ������������
	private int countSkilledworker;
	// ��ǰ������Ա
	private String approvalStaff;
	// ������ԱId
	private String approvalStaffId;
	// ��������Id
	private String approvalDept;
	// ������������
	private String approvalDeptName;
	// ��λ��Ա
	private int countPositions;
	private CityApprovalCondition condition = null;

	public void setCondition(CityApprovalCondition condition) {

		this.condition = condition;
	}

	public CityApprovalCondition getCondition() {
		CityApprovalCondition sessionCondition = (CityApprovalCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ѯ
	 * 
	 * @return
	 */
	public String queryPage() {
		// ��ȡ��ԱId
		String personalID = (String)this.get("personalID");
		// ��ȡ����Id
		String dept = (String)this.get("departmentID");
		if (dept.equals("230100")) {
			condition = new CityApprovalCondition(dept, personalID);
		} else {
			condition = new CityApprovalCondition(dept);
		}
		ICityApprovalService provinceApprovalService = new CityApprovalServiceImpl();
		// ��ҳ��ѯ
		currentPage = provinceApprovalService.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת����ҳ��
	 * 
	 * @return
	 */
	public String approvalPage() {
		ICityApprovalService provinceApprovalService = new CityApprovalServiceImpl();
		newQualification = provinceApprovalService.queryapproval(newQualId);
		Login login = (Login) this.get("login");
		// ��ǰ������Ա
		approvalStaff = login.getName();
		// ������ԱId
		approvalStaffId = login.getPersonalID();
		// ��ȡ����Id
		approvalDept = login.getDepartmentID();
		// ��ȡ��������
		approvalDeptName = login.getDepartment();
		// ��ѯְ����Ա����
		countTitle = provinceApprovalService.queryCountTitle(newQualification
				.getCorpId());
		// ע�Ὠ��ʦ����
		countConstructor = provinceApprovalService
				.queryCountConstructor(newQualification.getCorpName());
		// ��ѯ������������
		countSkilledworker = provinceApprovalService
				.queryCountSkilledworker(newQualification.getCorpId());
		// ��λ��Ա
		countPositions = provinceApprovalService
				.queryCountPositions(newQualification.getCorpName());

		// ����ύ��ʽΪ����
		if (newQualification.getAddTypeNum().equals("002")) {

			newQualification = provinceApprovalService
					.queryOldCretLevel(newQualification);
			return "approvalLevelPage";
		} else {
			return "approvalPage";
		}
	}

	/**
	 * ����ͨ��
	 * 
	 * @return
	 */
	public String applythrough() {
		ICityApprovalService provinceApprovalService = new CityApprovalServiceImpl();
		Login login = (Login) this.get("login");
		// ��ǰ������Ա
		newQualification.setApprovalStaff(login.getName());
		// ������ԱId
		newQualification.setApprovalStaffId(login.getPersonalID());
		// ��ȡ����Id
		newQualification.setApprovalDept(login.getDepartmentID());
		// ��ȡ��������
		newQualification.setApprovalDeptName(login.getDepartment());
		provinceApprovalService.applythrough(newQualification);
		return "query";
	}

	/**
	 * ��������
	 * 
	 * @return
	 */
	public String batchApplythrough() {
		ICityApprovalService provinceApprovalService = new CityApprovalServiceImpl();
		Login login = (Login) this.get("login");
		// ��ȡ��ԱId
		String personalID = login.getPersonalID();
		// ��ǰ������Ա
		approvalStaff = login.getName();
		provinceApprovalService.batchApplythrough(ids, approvalStaff,
				personalID);
		return "query";
	}

	/**
	 * �����˻�
	 * 
	 * @return
	 */
	public String applyBack() {
		ICityApprovalService provinceApprovalService = new CityApprovalServiceImpl();
		provinceApprovalService.applyBack(newQualification);
		return "query";
	}

	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionaryClass() {
		ICityApprovalService certifiedService = new CityApprovalServiceImpl();
		// ��������(�ֵ��TBAPTITUDEKINDDIC)
		cretTypes = certifiedService.queryCretTypes();
		// ���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
		cretLevels = certifiedService.queryCretLevels();
		// ��������(�ֵ��TBTRADETYPEDIC)
		cretSequences = certifiedService.queryCretSequences();
		// ���ʼ���(�ֵ��TBCRETGRADEDIC)
		cretGrades = certifiedService.queryCretGrades();
		// ��������(�ֵ��TBADDTYPEDIC)
		addTypeNums = certifiedService.queryAddTypeNums();
	}

	/**
	 * ����
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public String getCretSequenceId() {
		return cretSequenceId;
	}

	public void setCretSequenceId(String cretSequenceId) {
		this.cretSequenceId = cretSequenceId;
	}

	public List<DictionaryClass> getCretTypes() {
		return cretTypes;
	}

	public void setCretTypes(List<DictionaryClass> cretTypes) {
		this.cretTypes = cretTypes;
	}

	public List<DictionaryClass> getCretLevels() {
		return cretLevels;
	}

	public void setCretLevels(List<DictionaryClass> cretLevels) {
		this.cretLevels = cretLevels;
	}

	public List<DictionaryClass> getCretSequences() {
		return cretSequences;
	}

	public void setCretSequences(List<DictionaryClass> cretSequences) {
		this.cretSequences = cretSequences;
	}

	public List<DictionaryClass> getSpecialtyTypes() {
		return specialtyTypes;
	}

	public void setSpecialtyTypes(List<DictionaryClass> specialtyTypes) {
		this.specialtyTypes = specialtyTypes;
	}

	public List<DictionaryClass> getCretGrades() {
		return cretGrades;
	}

	public void setCretGrades(List<DictionaryClass> cretGrades) {
		this.cretGrades = cretGrades;
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

	public int getCountSkilledworker() {
		return countSkilledworker;
	}

	public void setCountSkilledworker(int countSkilledworker) {
		this.countSkilledworker = countSkilledworker;
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

	public int getCountPositions() {
		return countPositions;
	}

	public void setCountPositions(int countPositions) {
		this.countPositions = countPositions;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getApprovalStaffId() {
		return approvalStaffId;
	}

	public void setApprovalStaffId(String approvalStaffId) {
		this.approvalStaffId = approvalStaffId;
	}

	public String getApprovalDept() {
		return approvalDept;
	}

	public void setApprovalDept(String approvalDept) {
		this.approvalDept = approvalDept;
	}

	public String getApprovalDeptName() {
		return approvalDeptName;
	}

	public void setApprovalDeptName(String approvalDeptName) {
		this.approvalDeptName = approvalDeptName;
	}

}
