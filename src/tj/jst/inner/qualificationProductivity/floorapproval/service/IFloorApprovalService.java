package com.tj.jst.inner.qualificationProductivity.floorapproval.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 大厅审批服务接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IFloorApprovalService {

	/**
	 * 分页类
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * 查询审批信息
	 * 
	 * @param id
	 * @return
	 */
	public NewQualification queryInfo(String id);

	public NewQualification querPerchInfo(String id);

	/**
	 * 审批通过
	 * 
	 * @param floor
	 * @return
	 */
	public String approvalSuccess(FloorApproval floor , String name);

	public String perchApprovalSuccess(String id , String op , String name);

	/**
	 * 审批不通过
	 * 
	 * @param floor
	 * @return
	 */
	public String approvalFailed(FloorApproval floor , String name);

	public String perchApprovalFailed(String id , String op , String name);

	/**
	 * 审批完成后更改状态
	 * 
	 * @param approvalId
	 * @param approvalOpinion 
	 * @return
	 */
	public String changeType(String approvalId, String type,String name, String approvalOpinion);

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

	// 查询职称人员
	public int queryCountTitle(String userId);

	// 查询注册建造师
	public int queryCountConstructor(String userId);

	// 查询岗位人员
	public int queryCountPositions(String corpName);

	// 查询技术工人总数
	public int queryCountSkilledworker(String userId);

	//批量审批
	public List<NewQualification> batchApplythrough(String[] ids, String name);

}
