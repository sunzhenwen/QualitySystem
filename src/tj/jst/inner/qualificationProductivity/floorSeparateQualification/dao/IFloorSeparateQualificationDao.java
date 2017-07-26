package com.tj.jst.inner.qualificationProductivity.floorSeparateQualification.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 大厅受理换证数据库
 * 
 * @author Administrator
 *
 */
public interface IFloorSeparateQualificationDao {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * 查询审批详细
	 * 
	 * @param id
	 * @return
	 */
	public NewQualification queryPerchInfo(String id);

	/**
	 * 审批通过
	 * 
	 * @param id
	 * @param op
	 * @return
	 */
	public String perchApprovalSuccess(String id, String op , String name);

	/**
	 * 审批不通过
	 * 
	 * @param id
	 * @param op
	 * @return
	 */
	public String perchApprovalFailed(String id, String op , String name);

	/**
	 * 批量审批
	 * 
	 * @return
	 */
	public void batchApplythrough(List<NewQualification> list,String name);

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

	// 根据ids插叙已提交的资质服务事项
	public List<NewQualification> queryQualification(String[] ids);

	/**
	 * 查询企业信息
	 * 
	 * @param corpCode
	 * @return
	 */
	public CorpInfo queryCorpInfo(String corpCode);

}
