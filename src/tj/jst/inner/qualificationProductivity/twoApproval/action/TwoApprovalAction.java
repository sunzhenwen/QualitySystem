package com.tj.jst.inner.qualificationProductivity.twoApproval.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.twoApproval.condition.TwoApprovalCondition;
import com.tj.jst.inner.qualificationProductivity.twoApproval.service.TwoApprovalService;
import com.tj.jst.inner.qualificationProductivity.twoApproval.service.TwoApprovalServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 省级资质审批
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class TwoApprovalAction extends BaseAction {
	
	//主键
	private String newQualId;
	private String[] ids;
	NewQualification newQualification;
	//资质序列code
	private String cretSequenceId;
	//资质类型(字典表：TBAPTITUDEKINDDIC)
	private List<DictionaryClass> cretTypes;
	//资质等级(字典表：TBCERTTITLELEVELDIC)
	private List<DictionaryClass> cretLevels;
	//资质序列(字典表：TBTRADETYPEDIC)
	private List<DictionaryClass> cretSequences;
	//资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	private List<DictionaryClass> specialtyTypes;
	//资质级别(字典表：TBCRETGRADEDIC)
	private List<DictionaryClass> cretGrades;
	//申请类型(字典表：TBADDTYPEDIC)
	private List<DictionaryClass> addTypeNums;
	//职称人员总数
	private int countTitle;
	//注册建造师总数
	private int countConstructor;
	//技术工人总数
	private int countSkilledworker;
	//岗位人员
	private int countPositions;
	//当前审批人员
	private String approvalStaff;
	//审批人员Id
	private String approvalStaffId;
	
	private TwoApprovalCondition condition = new TwoApprovalCondition();
	
	public void setCondition(TwoApprovalCondition condition) {
		this.condition = condition;
	}

	public TwoApprovalCondition getCondition() {
		TwoApprovalCondition sessionCondition = (TwoApprovalCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		TwoApprovalService provinceApprovalService = new TwoApprovalServiceImpl();
		String departmentID = (String)this.get("departmentID");
		this.getCondition().setDeptId(departmentID);
		//分页查询
		currentPage = provinceApprovalService.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转审批页面
	 * @return
	 */
	public String approvalPage()
	{
		TwoApprovalService provinceApprovalService = new TwoApprovalServiceImpl();
		newQualification = provinceApprovalService.queryapproval(newQualId);
		Login login = (Login)this.get("login");
		//当前审批人员
		approvalStaff = login.getName();
		//审批人员Id
		approvalStaffId = login.getPersonalID();
		//查询职称人员总数
		countTitle = provinceApprovalService.queryCountTitle(newQualification.getCorpId());
		//注册建造师总数
		countConstructor = provinceApprovalService.queryCountConstructor(newQualification.getCorpName());
		//查询技术工人总数
		countSkilledworker = provinceApprovalService.queryCountSkilledworker(newQualification.getCorpId());
		//岗位人员
		countPositions = provinceApprovalService.queryCountPositions(newQualification.getCorpName());
				
		//如果提交方式为升级
		if(newQualification.getAddTypeNum().equals("002"))
		{
			
			newQualification = provinceApprovalService.queryOldCretLevel(newQualification);
//					//资质等级
//					System.out.println("资质资格等级= "+newQualification.getOldCretLevel()+" "+newQualification.getOldCretLevelName());
//					//资质资格级别
//					System.out.println("资质资格等级= "+newQualification.getOldCretGrade()+" "+newQualification.getOldCretGradeName());
//					//专业类别
//					System.out.println("资质资格等级= "+newQualification.getOldSpecialtyType()+" "+newQualification.getOldSpecialtyTypeName());
//					//企业
//					System.out.println("资质资格等级= "+newQualification.getCorpId()+" "+newQualification.getCorpName());
//					//申请时间
//					System.out.println("资质资格等级= "+newQualification.getOldCreatDate());
//					//审批通过时间
//					System.out.println("资质资格等级= "+newQualification.getOldUltimateDate());
			return "approvalLevelPage";
		}else
		{
			return "approvalPage";
		}
		
	}
	
	
	/**
	 * 审批通过
	 * @return
	 */
	public String applythrough()
	{
		TwoApprovalService provinceApprovalService = new TwoApprovalServiceImpl();
		provinceApprovalService.applythrough(newQualification);
		return "query";
	}
	
	/**
	 * 批量审批
	 * @return
	 */
	public String batchApplythrough()
	{
		TwoApprovalService provinceApprovalService = new TwoApprovalServiceImpl();
		Login login = (Login)this.get("login");
		//当前审批人员
		approvalStaff = login.getName();
		//审批人员Id
		approvalStaffId = login.getPersonalID();
		provinceApprovalService.batchApplythrough(ids,approvalStaff,approvalStaffId);
		return "query";
	}
	
	/**
	 * 申请退回
	 * @return
	 */
	public String applyBack()
	{
		TwoApprovalService provinceApprovalService = new TwoApprovalServiceImpl();
		provinceApprovalService.applyBack(newQualification);
		return "query";
	}
	
	/**
	 * 查询字典表
	 */
	public void queryDictionaryClass()
	{
		TwoApprovalService certifiedService = new TwoApprovalServiceImpl();
		//资质类型(字典表：TBAPTITUDEKINDDIC)
		cretTypes = certifiedService.queryCretTypes();
		//资质等级(字典表：TBCERTTITLELEVELDIC)
		cretLevels = certifiedService.queryCretLevels();
		//资质序列(字典表：TBTRADETYPEDIC)
		cretSequences = certifiedService.queryCretSequences();
		//资质级别(字典表：TBCRETGRADEDIC)
		cretGrades = certifiedService.queryCretGrades();
		//申请类型(字典表：TBADDTYPEDIC)
		addTypeNums = certifiedService.queryAddTypeNums();
	}

	/**
	 * 返回
	 * @return
	 */
	public String goBack()
	{
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
	
}
