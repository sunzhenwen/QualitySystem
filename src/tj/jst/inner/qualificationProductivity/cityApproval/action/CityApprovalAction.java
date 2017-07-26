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
 * 地市资质审批
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class CityApprovalAction extends BaseAction {

	// 主键
	private String newQualId;
	private String[] ids;
	NewQualification newQualification;
	// 资质序列code
	private String cretSequenceId;
	// 资质类型(字典表：TBAPTITUDEKINDDIC)
	private List<DictionaryClass> cretTypes;
	// 资质等级(字典表：TBCERTTITLELEVELDIC)
	private List<DictionaryClass> cretLevels;
	// 资质序列(字典表：TBTRADETYPEDIC)
	private List<DictionaryClass> cretSequences;
	// 资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	private List<DictionaryClass> specialtyTypes;
	// 资质级别(字典表：TBCRETGRADEDIC)
	private List<DictionaryClass> cretGrades;
	// 申请类型(字典表：TBADDTYPEDIC)
	private List<DictionaryClass> addTypeNums;
	// 职称人员总数
	private int countTitle;
	// 注册建造师总数
	private int countConstructor;
	// 技术工人总数
	private int countSkilledworker;
	// 当前审批人员
	private String approvalStaff;
	// 审批人员Id
	private String approvalStaffId;
	// 审批部门Id
	private String approvalDept;
	// 审批部门名称
	private String approvalDeptName;
	// 岗位人员
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
	 * 查询
	 * 
	 * @return
	 */
	public String queryPage() {
		// 获取人员Id
		String personalID = (String)this.get("personalID");
		// 获取部门Id
		String dept = (String)this.get("departmentID");
		if (dept.equals("230100")) {
			condition = new CityApprovalCondition(dept, personalID);
		} else {
			condition = new CityApprovalCondition(dept);
		}
		ICityApprovalService provinceApprovalService = new CityApprovalServiceImpl();
		// 分页查询
		currentPage = provinceApprovalService.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转审批页面
	 * 
	 * @return
	 */
	public String approvalPage() {
		ICityApprovalService provinceApprovalService = new CityApprovalServiceImpl();
		newQualification = provinceApprovalService.queryapproval(newQualId);
		Login login = (Login) this.get("login");
		// 当前审批人员
		approvalStaff = login.getName();
		// 审批人员Id
		approvalStaffId = login.getPersonalID();
		// 获取部门Id
		approvalDept = login.getDepartmentID();
		// 获取部门名称
		approvalDeptName = login.getDepartment();
		// 查询职称人员总数
		countTitle = provinceApprovalService.queryCountTitle(newQualification
				.getCorpId());
		// 注册建造师总数
		countConstructor = provinceApprovalService
				.queryCountConstructor(newQualification.getCorpName());
		// 查询技术工人总数
		countSkilledworker = provinceApprovalService
				.queryCountSkilledworker(newQualification.getCorpId());
		// 岗位人员
		countPositions = provinceApprovalService
				.queryCountPositions(newQualification.getCorpName());

		// 如果提交方式为升级
		if (newQualification.getAddTypeNum().equals("002")) {

			newQualification = provinceApprovalService
					.queryOldCretLevel(newQualification);
			return "approvalLevelPage";
		} else {
			return "approvalPage";
		}
	}

	/**
	 * 审批通过
	 * 
	 * @return
	 */
	public String applythrough() {
		ICityApprovalService provinceApprovalService = new CityApprovalServiceImpl();
		Login login = (Login) this.get("login");
		// 当前审批人员
		newQualification.setApprovalStaff(login.getName());
		// 审批人员Id
		newQualification.setApprovalStaffId(login.getPersonalID());
		// 获取部门Id
		newQualification.setApprovalDept(login.getDepartmentID());
		// 获取部门名称
		newQualification.setApprovalDeptName(login.getDepartment());
		provinceApprovalService.applythrough(newQualification);
		return "query";
	}

	/**
	 * 批量审批
	 * 
	 * @return
	 */
	public String batchApplythrough() {
		ICityApprovalService provinceApprovalService = new CityApprovalServiceImpl();
		Login login = (Login) this.get("login");
		// 获取人员Id
		String personalID = login.getPersonalID();
		// 当前审批人员
		approvalStaff = login.getName();
		provinceApprovalService.batchApplythrough(ids, approvalStaff,
				personalID);
		return "query";
	}

	/**
	 * 申请退回
	 * 
	 * @return
	 */
	public String applyBack() {
		ICityApprovalService provinceApprovalService = new CityApprovalServiceImpl();
		provinceApprovalService.applyBack(newQualification);
		return "query";
	}

	/**
	 * 查询字典表
	 */
	public void queryDictionaryClass() {
		ICityApprovalService certifiedService = new CityApprovalServiceImpl();
		// 资质类型(字典表：TBAPTITUDEKINDDIC)
		cretTypes = certifiedService.queryCretTypes();
		// 资质等级(字典表：TBCERTTITLELEVELDIC)
		cretLevels = certifiedService.queryCretLevels();
		// 资质序列(字典表：TBTRADETYPEDIC)
		cretSequences = certifiedService.queryCretSequences();
		// 资质级别(字典表：TBCRETGRADEDIC)
		cretGrades = certifiedService.queryCretGrades();
		// 申请类型(字典表：TBADDTYPEDIC)
		addTypeNums = certifiedService.queryAddTypeNums();
	}

	/**
	 * 返回
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
