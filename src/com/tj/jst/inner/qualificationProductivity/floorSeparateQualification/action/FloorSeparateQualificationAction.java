package com.tj.jst.inner.qualificationProductivity.floorSeparateQualification.action;

import java.util.Arrays;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;
import com.tj.jst.inner.qualificationProductivity.floorSeparateQualification.condition.FloorSeparateQualificationCondition;
import com.tj.jst.inner.qualificationProductivity.floorSeparateQualification.service.FloorSeparateQualificationServiceImpl;
import com.tj.jst.inner.qualificationProductivity.floorSeparateQualification.service.IFloorSeparateQualificationService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 大厅受理换证信息
 * 
 * @author Administrator
 *
 */
public class FloorSeparateQualificationAction extends BaseAction {

	private String corpName;// 企业名称
	private String corpCode;// 企业组织机构代码证
	private String id;// 查询主键
	private String op;// 审批意见
	private String message;// 返回信息
	private NewQualification newQualification;// 项目Model嘞
	private CorpInfo corp;
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
	// 岗位人员
	private int countPositions;
	private String[] ids;

	private String acceptDate;

	private FloorSeparateQualificationCondition condition = new FloorSeparateQualificationCondition();

	public void setCondition(FloorSeparateQualificationCondition condition) {
		this.condition = condition;
	}

	public FloorSeparateQualificationCondition getCondition() {
		FloorSeparateQualificationCondition sessionCondition = (FloorSeparateQualificationCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	public String queryPage() {
		IFloorSeparateQualificationService service = new FloorSeparateQualificationServiceImpl();
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		this.queryDictionaryClass();
		return "queryPage";
	}

	/**
	 * 审批详细
	 * 
	 * @return
	 */
	public String queryInfo() {
		IFloorSeparateQualificationService service = new FloorSeparateQualificationServiceImpl();
		newQualification = service.queryPerchInfo(id);
		corp = service.queryCorpInfo(newQualification.getCorpCode());
		// 查询职称人员总数
		countTitle = service.queryCountTitle(newQualification.getCorpId());
		// 注册建造师总数
		countConstructor = service.queryCountConstructor(newQualification
				.getCorpName());
		// 查询技术工人总数
		countSkilledworker = service.queryCountSkilledworker(newQualification
				.getCorpId());
		// 岗位人员
		countPositions = service.queryCountPositions(newQualification
				.getCorpName());
		condition.setCorpName(newQualification.getCountyName());
		return "queryInfo";
	}

	/**
	 * 审批通过
	 * 
	 * @return
	 */
	public String approvalSuccess() {
		IFloorSeparateQualificationService service = new FloorSeparateQualificationServiceImpl();
		Login login = (Login) this.get("login");
		message = service.perchApprovalSuccess(id, op,login.getName());
		condition.setCorpName(corpName);
		return this.queryPage();
	}

	/**
	 * 审批不通过
	 * 
	 * @return
	 */
	public String approvalFailed() {
		IFloorSeparateQualificationService service = new FloorSeparateQualificationServiceImpl();
		Login login = (Login) this.get("login");
		message = service.perchApprovalFailed(id, op,login.getName());
		condition.setCorpName(corpName);
		return this.queryPage();
	}

	/**
	 * 批量审批
	 */
	public String batchApplythrough() {
		IFloorSeparateQualificationService service = new FloorSeparateQualificationServiceImpl();
		Login login = (Login) this.get("login");
		System.out.println("ids = " + Arrays.toString(ids));
		service.batchApplythrough(ids , login.getName());
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

	/**
	 * 查询字典表
	 */
	public void queryDictionaryClass() {
		IFloorSeparateQualificationService service = new FloorSeparateQualificationServiceImpl();
		// 资质类型(字典表：TBAPTITUDEKINDDIC)
		cretTypes = service.queryCretTypes();
		// 资质等级(字典表：TBCERTTITLELEVELDIC)
		cretLevels = service.queryCretLevels();
		// 资质序列(字典表：TBTRADETYPEDIC)
		cretSequences = service.queryCretSequences();
		// 资质级别(字典表：TBCRETGRADEDIC)
		cretGrades = service.queryCretGrades();
		// 申请类型(字典表：TBADDTYPEDIC)
		addTypeNums = service.queryAddTypeNums();
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NewQualification getNewQualification() {
		return newQualification;
	}

	public void setNewQualification(NewQualification newQualification) {
		this.newQualification = newQualification;
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

	public List<DictionaryClass> getAddTypeNums() {
		return addTypeNums;
	}

	public void setAddTypeNums(List<DictionaryClass> addTypeNums) {
		this.addTypeNums = addTypeNums;
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

	public String getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(String acceptDate) {
		this.acceptDate = acceptDate;
	}

	public CorpInfo getCorp() {
		return corp;
	}

	public void setCorp(CorpInfo corp) {
		this.corp = corp;
	}

}
