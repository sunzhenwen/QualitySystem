package com.tj.jst.inner.qualificationProductivity.provinceApproval.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 省级资质审批
 * 
 * @author Administrator
 *
 */
public interface IProvinceApprovalService {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * 跳转审批页面(无需二级审批)
	 * 
	 * @return
	 */
	public NewQualification queryApproval(String newQualId);

	/**
	 * 审批通过(无需二级审批)
	 * 
	 * @return
	 */
	public void applyThrough(NewQualification newQualification);

	/**
	 * 申请退回(无需二级审批)
	 * 
	 * @return
	 */
	public void applyThroughBack(NewQualification newQualification);

	/**
	 * 推送外审
	 * 
	 * @return
	 */
	public void pushApply(NewQualification newQualification);

	/**
	 * 审批通过(经过二级审批进行终审)
	 * 
	 * @return
	 */
	public void applyUltimateThrough(NewQualification newQualification);

	/**
	 * 申请退回(经过初审终审退回)
	 * 
	 * @return
	 */
	public void applyUltimateThroughBack(NewQualification newQualification);

	/**
	 * 批量审批
	 * 
	 * @return
	 */
	public void batchApplythrough(String[] ids, String approvalStaff,
			String approvalStaffId);

	// 查询升级前,原资质信息
	public NewQualification queryOldCretLevel(NewQualification newQualification);

	// 查询职称人员
	public int queryCountTitle(String userId);

	// 查询注册建造师
	public int queryCountConstructor(String userName);

	// 查询岗位人员
	public int queryCountPositions(String corpName);

	// 查询技术工人总数
	public int queryCountSkilledworker(String userId);

	// 资质类型(字典表：TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCretTypes();

	// 资质等级(字典表：TBCERTTITLELEVELDIC)
	public List<DictionaryClass> queryCretLevels();

	// 资质序列(字典表：TBTRADETYPEDIC)
	public List<DictionaryClass> queryCretSequences();

	// 资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId);

	// 资质级别(字典表：TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades();

	// 申请类型(字典表：TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums();

	// 查询注册建造师list
	public Page queryConstructor(Condition constructocondition);

	// 技术工人list
	public Page querySkilledworker(Condition constructocondition);

	// 职称人员
	public Page queryTitle(Condition constructocondition);

	// 岗位人员
	public Page queryPositions(Condition constructocondition);

	// 岗位人员数目
	public List queryPositionsNum(String corpName);

	/**
	 * 查询重复的技术工人数目
	 * 
	 * @param corpName
	 * @return
	 */
	public String querySkillworkerNum(String corpName);

	/**
	 * 查询重复的职称人员数目
	 * 
	 * @param corpName
	 * @return
	 */
	public String queryTitleNum(String corpName);

	/**
	 * 查询重复的岗位人员数目
	 * 
	 * @param corpName
	 * @return
	 */
	public String queryPosNum(String corpName);

	/**
	 * 重复人员输出
	 * 
	 * @param condition
	 * @return
	 */
	public Page skillworkerNum(Condition condition);

	/**
	 * 重复职称人员输出
	 * 
	 * @param condition
	 * @return
	 */
	public Page titleNum(Condition condition);

	/**
	 * 重复岗位人员输出
	 * 
	 * @param condition
	 * @return
	 */
	public Page posNum(Condition condition);

}
