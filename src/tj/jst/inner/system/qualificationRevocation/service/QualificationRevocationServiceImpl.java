package com.tj.jst.inner.system.qualificationRevocation.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.qualificationRevocation.condition.RevocationHistoryCondition;
import com.tj.jst.inner.system.qualificationRevocation.dao.IQualificationRevocationDao;
import com.tj.jst.inner.system.qualificationRevocation.dao.QualificationRevocationDaoImpl;
import com.tj.jst.inner.system.qualificationRevocation.model.QualificationRevocation;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.inner.system.servicecertdetailinfo.model.Department;

/**
 * ��ҵ�ѻ����ʴ��
 * @author Administrator
 *
 */
public class QualificationRevocationServiceImpl implements IQualificationRevocationService {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQualificationRevocationDao dao = new QualificationRevocationDaoImpl();
		return dao.pagedQuery(condition);
	}
	
	/**
	 * ��ת���ҳ��
	 */
	@Override
	public QualificationRevocation revocationPage(String relationId) {
		// TODO Auto-generated method stub
		IQualificationRevocationDao dao = new QualificationRevocationDaoImpl();
		return dao.revocationPage(relationId);
	}
	
	/**
	 * ���ʴ�ز���
	 * @return
	 */
	@Override
	public String revocation(QualificationRevocation qualificationRevocation) {
		// TODO Auto-generated method stub
		IQualificationRevocationDao dao = new QualificationRevocationDaoImpl();
		return dao.revocation(qualificationRevocation);
	}
	
	//��������(�ֵ��TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		IQualificationRevocationDao certifiedServiceDao = new QualificationRevocationDaoImpl();
		return certifiedServiceDao.queryCretTypes();
	}

	//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		IQualificationRevocationDao certifiedServiceDao = new QualificationRevocationDaoImpl();
		return certifiedServiceDao.queryCretLevels();
	}

	//��������(�ֵ��TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		IQualificationRevocationDao certifiedServiceDao = new QualificationRevocationDaoImpl();
		return certifiedServiceDao.queryCretSequences();
	}

	//����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		IQualificationRevocationDao certifiedServiceDao = new QualificationRevocationDaoImpl();
		return certifiedServiceDao.querySpecialtyTypes(cretSequenceId);
	}
	//���ʼ���(�ֵ��TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades()
	{
		IQualificationRevocationDao certifiedServiceDao = new QualificationRevocationDaoImpl();
		return certifiedServiceDao.queryCretGrades();
	}
	public List<Department> getDepartment()
	{
		IQualificationRevocationDao certifiedServiceDao = new QualificationRevocationDaoImpl();
		return certifiedServiceDao.getDepartment();
	}

	
	
}
