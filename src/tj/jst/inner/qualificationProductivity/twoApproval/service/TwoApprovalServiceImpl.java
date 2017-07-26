package com.tj.jst.inner.qualificationProductivity.twoApproval.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.twoApproval.dao.ITwoApprovalDao;
import com.tj.jst.inner.qualificationProductivity.twoApproval.dao.TwoApprovalDaoImpl;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ʡ����������
 * @author Administrator
 *
 */
public class TwoApprovalServiceImpl implements TwoApprovalService {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.pagedQuery(condition);
	}
	/**
	 * ��ת����ҳ���ѯ  
	 */
	public NewQualification queryapproval(String newQualId)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryapproval(newQualId);
	}
	/**
	 * ����ͨ��
	 * @return
	 */
	public void applythrough(NewQualification newQualification)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		qualificationsApprovalDao.applythrough(newQualification);
	}
	/**
	 * �����˻�
	 * @return
	 */
	public void applyBack(NewQualification newQualification)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		qualificationsApprovalDao.applyBack(newQualification);
	}
	//��ѯְ����Ա
	public int queryCountTitle(String userId)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountTitle(userId);
	}
	//��ѯע�Ὠ��ʦ
	public int queryCountConstructor(String userId)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountConstructor(userId);
	}
	//��ѯ������������
	public int queryCountSkilledworker(String userId)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountSkilledworker(userId);
	}
	//��������(�ֵ��TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretTypes();
	}

	//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretLevels();
	}

	//��������(�ֵ��TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretSequences();
	}

	//����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.querySpecialtyTypes(cretSequenceId);
	}
	//���ʼ���(�ֵ��TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades()
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCretGrades();
	}
	//��������(�ֵ��TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums()
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryAddTypeNums();
	}
	//��ѯ��λ��Ա
	public int queryCountPositions(String corpName)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryCountPositions(corpName);
	}
	//��ѯ����ǰ,ԭ������Ϣ
	public NewQualification queryOldCretLevel(NewQualification newQualification)
	{
		ITwoApprovalDao qualificationsApprovalDao = new TwoApprovalDaoImpl();
		return qualificationsApprovalDao.queryOldCretLevel(newQualification);
	}
	
	/**
	 * ��������
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
			list.get(i).setOneUltimateOpinion("����ͨ��");
			this.applythrough(list.get(i));
		}
		
	}

}
