package com.tj.jst.inner.qualificationProductivity.twoApproval.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.twoApproval.dao.ITwoApprovalDao;
import com.tj.jst.inner.qualificationProductivity.twoApproval.dao.TwoApprovalDaoImpl;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 省级资质审批
 * @author Administrator
 *
 */
public class TwoApprovalServiceImpl implements TwoApprovalService {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.pagedQuery(condition);
	}
	/**
	 * 跳转审批页面查询  
	 */
	public NewQualification queryapproval(String newQualId)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryapproval(newQualId);
	}
	/**
	 * 审批通过
	 * @return
	 */
	public void applythrough(NewQualification newQualification)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		qualificationsApprovalDao.applythrough(newQualification);
	}
	/**
	 * 申请退回
	 * @return
	 */
	public void applyBack(NewQualification newQualification)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		qualificationsApprovalDao.applyBack(newQualification);
	}
	//查询职称人员
	public int queryCountTitle(String userId)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountTitle(userId);
	}
	//查询注册建造师
	public int queryCountConstructor(String userId)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountConstructor(userId);
	}
	//查询技术工人总数
	public int queryCountSkilledworker(String userId)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountSkilledworker(userId);
	}
	//资质类型(字典表：TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretTypes();
	}

	//资质等级(字典表：TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretLevels();
	}

	//资质序列(字典表：TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretSequences();
	}

	//资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.querySpecialtyTypes(cretSequenceId);
	}
	//资质级别(字典表：TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades()
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretGrades();
	}
	//申请类型(字典表：TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums()
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryAddTypeNums();
	}
	//查询岗位人员
	public int queryCountPositions(String corpName)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountPositions(corpName);
	}
	//查询升级前,原资质信息
	public NewQualification queryOldCretLevel(NewQualification newQualification)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryOldCretLevel(newQualification);
	}
	
	/**
	 * 批量审批
	 * @return
	 */
	public void batchApplythrough(String[] ids,String approvalStaff,String approvalStaffId)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		List<NewQualification> list = qualificationsApprovalDao.queryQualification(ids);
		
		for(int i=0;i<list.size();i++)
		{
			list.get(i).setTwoApprovalStaff(approvalStaff);
			list.get(i).setTwoApprovalStaffId(approvalStaffId);
			list.get(i).setOneUltimateOpinion("审批通过");
			this.applythrough(list.get(i));
		}
		
	}

}
