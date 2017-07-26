package com.tj.jst.inner.qualificationProductivity.cityApproval.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.CertifiedCode;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.cityApproval.dao.CityApprovalDaoImpl;
import com.tj.jst.inner.qualificationProductivity.cityApproval.dao.ICityApprovalDao;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 地市资质审批
 * @author Administrator
 *
 */
public class CityApprovalServiceImpl implements ICityApprovalService {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.pagedQuery(condition);
	}
	/**
	 * 跳转审批页面查询  
	 */
	public NewQualification queryapproval(String newQualId)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryapproval(newQualId);
	}
	/**
	 * 审批通过
	 * @return
	 */
	public void applythrough(NewQualification newQualification)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		//查询证书编号是否已经存在
		String certId = qualificationsApprovalDao.queryCertId(newQualification);
		if(certId.equals(""))
		{
			int serNum = CertifiedCode.querySerNum();
			if(serNum!=-1)
			{
				String certifiedCode = CertifiedCode.getCertifiedCode(newQualification.getEconomicNum()+"", newQualification.getCretGrade(),serNum);
				qualificationsApprovalDao.applythrough(newQualification,certifiedCode);
			}
		}else
		{
			qualificationsApprovalDao.applythrough(newQualification,certId);
		}
	}
	/**
	 * 申请退回
	 * @return
	 */
	public void applyBack(NewQualification newQualification)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		qualificationsApprovalDao.applyBack(newQualification);
	}
	//查询职称人员
	public int queryCountTitle(String userId)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountTitle(userId);
	}
	//查询注册建造师
	public int queryCountConstructor(String userId)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountConstructor(userId);
	}
	//查询技术工人总数
	public int queryCountSkilledworker(String userId)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountSkilledworker(userId);
	}
	//资质类型(字典表：TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretTypes();
	}

	//资质等级(字典表：TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretLevels();
	}

	//资质序列(字典表：TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretSequences();
	}

	//资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.querySpecialtyTypes(cretSequenceId);
	}
	//资质级别(字典表：TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades()
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretGrades();
	}
	//申请类型(字典表：TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums()
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryAddTypeNums();
	}
	//查询岗位人员
	public int queryCountPositions(String corpName)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountPositions(corpName);
	}
	//查询升级前,原资质信息
	public NewQualification queryOldCretLevel(NewQualification newQualification)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryOldCretLevel(newQualification);
	}
	/**
	 * 批量审批
	 * @return
	 */
	public void batchApplythrough(String[] ids,String approvalStaff,String approvalStaffId)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		List<NewQualification> list = qualificationsApprovalDao.queryQualification(ids);
		
		for(int i=0;i<list.size();i++)
		{
			list.get(i).setApprovalStaff(approvalStaff);
			list.get(i).setApprovalStaffId(approvalStaffId);
			list.get(i).setUltimateOpinion("审批通过");
			this.applythrough(list.get(i));
		}
		
	}
}
