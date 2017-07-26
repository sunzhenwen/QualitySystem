package com.tj.jst.inner.qualificationProductivity.countryApproval.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.countryApproval.dao.CountryApprovalDaoImpl;
import com.tj.jst.inner.qualificationProductivity.countryApproval.dao.ICountryApprovalDao;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 国家资质审批
 * @author Administrator
 *
 */
public class CountryApprovalServiceImpl implements ICountryApprovalService {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.pagedQuery(condition);
	}
	/**
	 * 跳转审批页面查询 (无需二级审批)
	 */
	public NewQualification queryApproval(String newQualId)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryApproval(newQualId);
	}
	/**
	 * 审批通过(无需二级审批)
	 * @return
	 */
	public void applyThrough(NewQualification newQualification)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
//		//查询证书编号是否已经存在
//		String certId = qualificationsApprovalDao.queryCertId(newQualification);
//		if(certId.equals(""))
//		{
//			int serNum = CertifiedCode.querySerNum();
//			if(serNum!=-1)
//			{
//				String certifiedCode = CertifiedCode.getCertifiedCode(newQualification.getEconomicNum()+"", newQualification.getCretGrade(),serNum);
//				qualificationsApprovalDao.applyThrough(newQualification,certifiedCode);
//			}
//		}else
//		{
//			qualificationsApprovalDao.applyThrough(newQualification,certId);
//		}
		qualificationsApprovalDao.applyThrough(newQualification,"");
	}
	/**
	 * 申请退回(无需二级审批)
	 * @return
	 */
	public void applyThroughBack(NewQualification newQualification)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		qualificationsApprovalDao.applyThroughBack(newQualification);
	}
	/**
	 * 审批通过(经过二级审批进行终审)
	 * @return
	 */
	public void applyUltimateThrough(NewQualification newQualification)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
//		//查询证书编号是否已经存在
//		String certId = qualificationsApprovalDao.queryCertId(newQualification);
//		if(certId.equals(""))
//		{
//			int serNum = CertifiedCode.querySerNum();
//			if(serNum!=-1)
//			{
//				String certifiedCode = CertifiedCode.getCertifiedCode(newQualification.getEconomicNum()+"", newQualification.getCretGrade(),serNum);
//				qualificationsApprovalDao.applyUltimateThrough(newQualification,certifiedCode);
//			}
//		}else
//		{
//			qualificationsApprovalDao.applyUltimateThrough(newQualification,certId);
//		}
		qualificationsApprovalDao.applyUltimateThrough(newQualification,"");
	}
	/**
	 * 申请退回(经过初审终审退回)
	 * @return
	 */
	public void applyUltimateThroughBack(NewQualification newQualification)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		qualificationsApprovalDao.applyUltimateThroughBack(newQualification);
	}
	

	
	/**
	 * 推送外审
	 * @return
	 */
	public void pushApply(NewQualification newQualification)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		qualificationsApprovalDao.pushApply(newQualification);
	}

	//查询职称人员
	public int queryCountTitle(String userId)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountTitle(userId);
	}
	//查询注册建造师
	public int queryCountConstructor(String userId)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountConstructor(userId);
	}
	//查询岗位人员
	public int queryCountPositions(String corpName)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountPositions(corpName);
	}
	//查询技术工人总数
	public int queryCountSkilledworker(String userId)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountSkilledworker(userId);
	}
	//资质类型(字典表：TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretTypes();
	}

	//资质等级(字典表：TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretLevels();
	}

	//资质序列(字典表：TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretSequences();
	}

	//资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.querySpecialtyTypes(cretSequenceId);
	}
	//资质级别(字典表：TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades()
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretGrades();
	}
	//申请类型(字典表：TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums()
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryAddTypeNums();
	}
	//查询升级前,原资质信息
	public NewQualification queryOldCretLevel(NewQualification newQualification)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryOldCretLevel(newQualification);
	}
	/**
	 * 批量审批
	 * @return
	 */
	public void batchApplythrough(String[] ids,String approvalStaff,String approvalStaffId)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		List<NewQualification> list = qualificationsApprovalDao.queryQualification(ids);
		
		for(int i=0;i<list.size();i++)
		{
			//判断是否为二级审批资质
			if(!list.get(i).getTwoApprovalDept().trim().equals("0"))
			{
				//判断是否经过初审
				if(list.get(i).getTwoApprovalStaffId() == null)
				{
					//如果未经过初级审批，进行推送初审
					this.pushApply(list.get(i));
				}else
				{
					list.get(i).setApprovalStaff(approvalStaff);
					list.get(i).setApprovalStaffId(approvalStaffId);
					list.get(i).setUltimateOpinion("审批通过");
					//否则进行终极审批
					this.applyUltimateThrough(list.get(i));
				}
			}else
			{
				list.get(i).setApprovalStaff(approvalStaff);
				list.get(i).setApprovalStaffId(approvalStaffId);
				list.get(i).setUltimateOpinion("审批通过");
				this.applyThrough(list.get(i));
			}
		}
		
	}
}
