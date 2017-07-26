package com.tj.jst.inner.qualificationProductivity.provinceApproval.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.ProvinceApprovalCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.IProvinceApprovalService;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.ProvinceApprovalServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * 省级资质审批
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class ProvinceApprovalAction extends BaseAction {

	// 主键
	private String newQualId;
	private String[] ids;
	private NewQualification newQualification;
	private String message;
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
	// 岗位人员
	private int countPositions;
	// 注册建造师list
	private List<Constructor> constructors;
	// 技术工人总数
	private int countSkilledworker;
	// 当前审批人员
	private String approvalStaff;
	// 审批人员Id
	private String approvalStaffId;
	private String corpId;
	private String checkNum;

	private ProvinceApprovalCondition condition = new ProvinceApprovalCondition();

	public void setCondition(ProvinceApprovalCondition condition) {
		this.condition = condition;
	}

	public ProvinceApprovalCondition getCondition() {
		ProvinceApprovalCondition sessionCondition = (ProvinceApprovalCondition) get(getActionName());
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
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		String departmentID = (String)this.get("departmentID");
		this.getCondition().setDeptId(departmentID);
		// 分页查询
		currentPage = provinceApprovalService.pagedQuery(this.getCondition());
		if (departmentID.trim().equals("400182")) {
			checkNum = "1";
		}
		this.queryDictionaryClass();
		this.set(getActionName(), this.getCondition());
		return "queryPage";
	}

	/**
	 * 跳转审批页面
	 * 
	 * @return
	 */
	public String approvalPage() {
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		String returnPage = "";
		// 查询审批资质信息
		newQualification = provinceApprovalService.queryApproval(newQualId);

		Login login = (Login) this.get("login");
		// 当前审批人员
		approvalStaff = login.getName();
		// 审批人员Id
		approvalStaffId = login.getPersonalID();
		// 查询职称人员总数
		countTitle = provinceApprovalService.queryCountTitle(newQualification
				.getCorpId());
		// 注册建造师总数
		countConstructor = provinceApprovalService
				.queryCountConstructor(newQualification.getCorpName());
		// 岗位人员
		countPositions = provinceApprovalService
				.queryCountPositions(newQualification.getCorpName());
		// 查询技术工人总数
		countSkilledworker = provinceApprovalService
				.queryCountSkilledworker(newQualification.getCorpId());

		// 不需要二级审批
		if (newQualification.getTwoApprovalDept().equals("0")) {
			// 如果提交方式为升级
			if (newQualification.getAddTypeNum().equals("002")) {

				newQualification = provinceApprovalService
						.queryOldCretLevel(newQualification);
				returnPage = "approvalLevelPage";
			} else {
				returnPage = "approvalPage";
			}

		}

		// 需要二级审批
		if (!newQualification.getTwoApprovalDept().equals("0")) {
			// 如果提交方式为升级
			if (newQualification.getAddTypeNum().equals("002")) {
				newQualification = provinceApprovalService
						.queryOldCretLevel(newQualification);
				returnPage = "deliveryLevelPage";
			} else {
				returnPage = "deliveryPage";
			}
		}

		// 经过初审
		if (newQualification.getQualifType().equals("3")
				|| newQualification.getQualifType().equals("4")) {
			// 如果提交方式为升级
			if (newQualification.getAddTypeNum().equals("002")) {

				newQualification = provinceApprovalService
						.queryOldCretLevel(newQualification);
				returnPage = "ultimateApprovalLevelPage";
			} else {
				returnPage = "ultimateApproval";
			}
		}
		return returnPage;
	}

	/**
	 * 审批通过(无需二级审批)
	 * 
	 * @return
	 */
	public String applyThrough() {
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		provinceApprovalService.applyThrough(newQualification);
		return "query";
	}

	/**
	 * 申请退回(无需二级审批)
	 * 
	 * @return
	 */
	public String applyThroughBack() {
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		provinceApprovalService.applyThroughBack(newQualification);
		return "query";
	}

	/**
	 * 推送外审
	 * 
	 * @return
	 */
	public String pushApply() {
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		provinceApprovalService.pushApply(newQualification);
		return "query";
	}

	/**
	 * 审批通过(经过二级审批进行终审)
	 * 
	 * @return
	 */
	public String applyUltimateThrough() {
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		provinceApprovalService.applyUltimateThrough(newQualification);
		return "query";
	}

	/**
	 * 申请退回(经过初审终审退回)
	 * 
	 * @return
	 */
	public String applyUltimateThroughBack() {
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		provinceApprovalService.applyUltimateThroughBack(newQualification);
		return "query";
	}

	/**
	 * 查询字典表
	 */
	public void queryDictionaryClass() {
		IProvinceApprovalService certifiedService = new ProvinceApprovalServiceImpl();
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
	 * 批量审批
	 * 
	 * @return
	 */
	public String batchApplythrough() {
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		Login login = (Login) this.get("login");
		// 当前审批人员
		approvalStaff = login.getName();
		// 审批人员Id
		approvalStaffId = login.getPersonalID();
		provinceApprovalService.batchApplythrough(ids, approvalStaff,
				approvalStaffId);
		return "query";
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

	public String getApprovalStaffId() {
		return approvalStaffId;
	}

	public void setApprovalStaffId(String approvalStaffId) {
		this.approvalStaffId = approvalStaffId;
	}

	public List<Constructor> getConstructors() {
		return constructors;
	}

	public void setConstructors(List<Constructor> constructors) {
		this.constructors = constructors;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCheckNum() {
		return checkNum;
	}

	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}

}
