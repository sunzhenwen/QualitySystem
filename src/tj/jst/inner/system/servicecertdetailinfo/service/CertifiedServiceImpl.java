package com.tj.jst.inner.system.servicecertdetailinfo.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.servicecertdetailinfo.dao.CertifiedServiceDaoImpl;
import com.tj.jst.inner.system.servicecertdetailinfo.dao.ICertifiedServiceDao;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.inner.system.servicecertdetailinfo.model.Department;

/**
 * ���ʷ�������ά��
 * @author Administrator
 *
 */
public class CertifiedServiceImpl implements ICertifiedService {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.pagedQuery(condition);
	}

	/**
	 * ���
	 * @param certifiedService
	 */
	public void addCertifiedService(CertifiedService certifiedService)
	{
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		certifiedServiceDao.addCertifiedService(certifiedService);
	}
	
	/**
	 * ��ѯ����
	 * @param certifiedService
	 */
	public CertifiedService queryById(String certId)
	{
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.queryById(certId);
	}
	
	/**
	 * �޸�
	 * @param certifiedService
	 */
	public void modifyCertifiedService(CertifiedService certifiedService)
	{
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		certifiedServiceDao.modifyCertifiedService(certifiedService);
	}
	
	/**
	 * ɾ��
	 */
	public void delectCertifiedService(String[] certIds)
	{
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		certifiedServiceDao.delectCertifiedService(certIds);
	}
	
	//��������(�ֵ��TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.queryCretTypes();
	}

	//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.queryCretLevels();
	}

	//��������(�ֵ��TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.queryCretSequences();
	}

	//����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.querySpecialtyTypes(cretSequenceId);
	}
	//���ʼ���(�ֵ��TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades()
	{
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.queryCretGrades();
	}
	public List<Department> getDepartment()
	{
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.getDepartment();
	}
}
