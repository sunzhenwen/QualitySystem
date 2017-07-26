package com.tj.jst.inner.system.qualificationRevocation.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.qualificationRevocation.condition.RevocationHistoryCondition;
import com.tj.jst.inner.system.qualificationRevocation.dao.IRevocationHistoryDao;
import com.tj.jst.inner.system.qualificationRevocation.dao.RevocationHistoryDaoImpl;
import com.tj.jst.inner.system.qualificationRevocation.model.QualificationRevocation;
import com.tj.jst.inner.system.servicecertdetailinfo.model.Department;

/**
 * ��ҵ�ѻ����ʴ��
 * @author Administrator
 *
 */
public class RevocationHistoryServiceImpl implements IRevocationHistoryService {

	
	/**
	 * ���ʴ����ʷ
	 */
	@Override
	public Page pagedQueryHistory(RevocationHistoryCondition historyCondition) {
		IRevocationHistoryDao dao = new RevocationHistoryDaoImpl();
		return dao.pagedQueryHistory(historyCondition);
	}

	//��������(�ֵ��TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		IRevocationHistoryDao certifiedServiceDao = new RevocationHistoryDaoImpl();
		return certifiedServiceDao.queryCretTypes();
	}

	//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		IRevocationHistoryDao certifiedServiceDao = new RevocationHistoryDaoImpl();
		return certifiedServiceDao.queryCretLevels();
	}

	//��������(�ֵ��TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		IRevocationHistoryDao certifiedServiceDao = new RevocationHistoryDaoImpl();
		return certifiedServiceDao.queryCretSequences();
	}

	//����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		IRevocationHistoryDao certifiedServiceDao = new RevocationHistoryDaoImpl();
		return certifiedServiceDao.querySpecialtyTypes(cretSequenceId);
	}
	//���ʼ���(�ֵ��TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades()
	{
		IRevocationHistoryDao certifiedServiceDao = new RevocationHistoryDaoImpl();
		return certifiedServiceDao.queryCretGrades();
	}
	public List<Department> getDepartment()
	{
		IRevocationHistoryDao certifiedServiceDao = new RevocationHistoryDaoImpl();
		return certifiedServiceDao.getDepartment();
	}

	/**
	 * ���ʴ����ʷ��ϸ
	 */
	@Override
	public QualificationRevocation revocationHistoryPage(String revocationId) {
		// TODO Auto-generated method stub
		IRevocationHistoryDao dao = new RevocationHistoryDaoImpl();
		return dao.revocationHistoryPage(revocationId);
	}

	
	
}
