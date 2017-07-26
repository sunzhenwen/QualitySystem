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
 * 全部信息查询
 * 
 * @author DarkFlameMaster
 *
 */
public class QuerySeparateQualificationAction extends BaseAction {

	// 主键
	private String newQualId;
	NewQualification newQualification;
	NewQualification oldQualification;
	// 职称人员总数
	private int countTitle;
	// 注册建造师总数
	private int countConstructor;
	// 岗位人员
	private int countPositions;
	// 技术工人总数
	private int countSkilledworker;

	// 资质等级(字典表：TBCERTTITLELEVELDIC)
	private List<DictionaryClass> cretLevels;
	// 申请类型(字典表：TBADDTYPEDIC)
	private List<DictionaryClass> addTypeNums;
	// 标志
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
	 * 分页查询
	 */
	public String queryPage() {
		IQuerySeparateQualificationService allService = new QuerySeparateQualificationServiceImpl();
		// 分页查询
		currentPage = allService.pagedQuery(this.getCondition());
		this.queryDictionaryClass();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转查询页面
	 */
	public String infoPage() {
		IQuerySeparateQualificationService allService = new QuerySeparateQualificationServiceImpl();
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		newQualification = allService.queryapproval(newQualId);
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

		mark = allService.queryUpdate(newQualId);
		if (mark.equals("升级")) {
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
	 * 查询字典表
	 */
	public void queryDictionaryClass() {
		IQuerySeparateQualificationService allService = new QuerySeparateQualificationServiceImpl();
		// 资质等级(字典表：TBCERTTITLELEVELDIC)
		cretLevels = allService.queryCretLevels();
		// 申请类型(字典表：TBADDTYPEDIC)
		addTypeNums = allService.queryAddTypeNums();
	}

	/**
	 * 返回
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
