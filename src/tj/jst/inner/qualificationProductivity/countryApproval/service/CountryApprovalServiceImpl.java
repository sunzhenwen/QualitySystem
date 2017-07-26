package com.tj.jst.inner.qualificationProductivity.countryApproval.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.countryApproval.dao.CountryApprovalDaoImpl;
import com.tj.jst.inner.qualificationProductivity.countryApproval.dao.ICountryApprovalDao;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ������������
 * @author Administrator
 *
 */
public class CountryApprovalServiceImpl implements ICountryApprovalService {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.pagedQuery(condition);
	}
	/**
	 * ��ת����ҳ���ѯ (�����������)
	 */
	public NewQualification queryApproval(String newQualId)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryApproval(newQualId);
	}
	/**
	 * ����ͨ��(�����������)
	 * @return
	 */
	public void applyThrough(NewQualification newQualification)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
//		//��ѯ֤�����Ƿ��Ѿ�����
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
	 * �����˻�(�����������)
	 * @return
	 */
	public void applyThroughBack(NewQualification newQualification)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		qualificationsApprovalDao.applyThroughBack(newQualification);
	}
	/**
	 * ����ͨ��(��������������������)
	 * @return
	 */
	public void applyUltimateThrough(NewQualification newQualification)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
//		//��ѯ֤�����Ƿ��Ѿ�����
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
	 * �����˻�(�������������˻�)
	 * @return
	 */
	public void applyUltimateThroughBack(NewQualification newQualification)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		qualificationsApprovalDao.applyUltimateThroughBack(newQualification);
	}
	

	
	/**
	 * ��������
	 * @return
	 */
	public void pushApply(NewQualification newQualification)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		qualificationsApprovalDao.pushApply(newQualification);
	}

	//��ѯְ����Ա
	public int queryCountTitle(String userId)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountTitle(userId);
	}
	//��ѯע�Ὠ��ʦ
	public int queryCountConstructor(String userId)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountConstructor(userId);
	}
	//��ѯ��λ��Ա
	public int queryCountPositions(String corpName)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountPositions(corpName);
	}
	//��ѯ������������
	public int queryCountSkilledworker(String userId)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountSkilledworker(userId);
	}
	//��������(�ֵ��TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretTypes();
	}

	//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretLevels();
	}

	//��������(�ֵ��TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretSequences();
	}

	//����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.querySpecialtyTypes(cretSequenceId);
	}
	//���ʼ���(�ֵ��TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades()
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretGrades();
	}
	//��������(�ֵ��TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums()
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryAddTypeNums();
	}
	//��ѯ����ǰ,ԭ������Ϣ
	public NewQualification queryOldCretLevel(NewQualification newQualification)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		return qualificationsApprovalDao.queryOldCretLevel(newQualification);
	}
	/**
	 * ��������
	 * @return
	 */
	public void batchApplythrough(String[] ids,String approvalStaff,String approvalStaffId)
	{
		ICountryApprovalDao qualificationsApprovalDao = new CountryApprovalDaoImpl();
		List<NewQualification> list = qualificationsApprovalDao.queryQualification(ids);
		
		for(int i=0;i<list.size();i++)
		{
			//�ж��Ƿ�Ϊ������������
			if(!list.get(i).getTwoApprovalDept().trim().equals("0"))
			{
				//�ж��Ƿ񾭹�����
				if(list.get(i).getTwoApprovalStaffId() == null)
				{
					//���δ���������������������ͳ���
					this.pushApply(list.get(i));
				}else
				{
					list.get(i).setApprovalStaff(approvalStaff);
					list.get(i).setApprovalStaffId(approvalStaffId);
					list.get(i).setUltimateOpinion("����ͨ��");
					//��������ռ�����
					this.applyUltimateThrough(list.get(i));
				}
			}else
			{
				list.get(i).setApprovalStaff(approvalStaff);
				list.get(i).setApprovalStaffId(approvalStaffId);
				list.get(i).setUltimateOpinion("����ͨ��");
				this.applyThrough(list.get(i));
			}
		}
		
	}
}
