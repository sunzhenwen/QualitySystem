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
 * ������������
 * @author Administrator
 *
 */
public class CityApprovalServiceImpl implements ICityApprovalService {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.pagedQuery(condition);
	}
	/**
	 * ��ת����ҳ���ѯ  
	 */
	public NewQualification queryapproval(String newQualId)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryapproval(newQualId);
	}
	/**
	 * ����ͨ��
	 * @return
	 */
	public void applythrough(NewQualification newQualification)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		//��ѯ֤�����Ƿ��Ѿ�����
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
	 * �����˻�
	 * @return
	 */
	public void applyBack(NewQualification newQualification)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		qualificationsApprovalDao.applyBack(newQualification);
	}
	//��ѯְ����Ա
	public int queryCountTitle(String userId)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountTitle(userId);
	}
	//��ѯע�Ὠ��ʦ
	public int queryCountConstructor(String userId)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountConstructor(userId);
	}
	//��ѯ������������
	public int queryCountSkilledworker(String userId)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountSkilledworker(userId);
	}
	//��������(�ֵ��TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretTypes();
	}

	//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretLevels();
	}

	//��������(�ֵ��TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretSequences();
	}

	//����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.querySpecialtyTypes(cretSequenceId);
	}
	//���ʼ���(�ֵ��TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades()
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretGrades();
	}
	//��������(�ֵ��TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums()
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryAddTypeNums();
	}
	//��ѯ��λ��Ա
	public int queryCountPositions(String corpName)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountPositions(corpName);
	}
	//��ѯ����ǰ,ԭ������Ϣ
	public NewQualification queryOldCretLevel(NewQualification newQualification)
	{
		ICityApprovalDao qualificationsApprovalDao = new CityApprovalDaoImpl();
		return qualificationsApprovalDao.queryOldCretLevel(newQualification);
	}
	/**
	 * ��������
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
			list.get(i).setUltimateOpinion("����ͨ��");
			this.applythrough(list.get(i));
		}
		
	}
}
