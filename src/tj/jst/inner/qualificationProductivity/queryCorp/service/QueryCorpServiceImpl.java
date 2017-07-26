package com.tj.jst.inner.qualificationProductivity.queryCorp.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.queryCorp.dao.IQueryCorpDao;
import com.tj.jst.inner.qualificationProductivity.queryCorp.dao.QueryCorpDaoImpl;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

public class QueryCorpServiceImpl implements IQueryCorpService{

	
	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IQueryCorpDao corpDao = new QueryCorpDaoImpl();
		return corpDao.pagedQuery(condition);
	}

	/**
	 * ����������Ϣ
	 */
	@Override
	public List<CertifiedService> queryCertifiedService(String[] certIds) {
		// TODO Auto-generated method stub
		IQueryCorpDao corpDao = new QueryCorpDaoImpl();
		return corpDao.queryCertifiedService(certIds);
	}

	/**
	 * �����ύ������Id��ѡ�����˾��Ϣ
	 */
	@Override
	public List<Corp> submitCertifiedService(String[] certIds) {
		// TODO Auto-generated method stub
		IQueryCorpDao corpDao = new QueryCorpDaoImpl();
		List<CertifiedService> list = corpDao.queryCertifiedService(certIds);
		return corpDao.submitCertifiedService(list);
	}


	/**
	 * ��ѯ����������Ϣ
	 */
	@Override
	public List<CertifiedService> queryAllCertifiedService() {
		// TODO Auto-generated method stub
		IQueryCorpDao corpDao = new QueryCorpDaoImpl();
		return corpDao.queryAllCertifiedService();
	}

	@Override
	public List<DictionaryClass> certName(String[] certIds) {
		// TODO Auto-generated method stub
		IQueryCorpDao corpDao = new QueryCorpDaoImpl();
		return corpDao.certName(certIds);
	}

	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
		IQueryCorpDao corpDao = new QueryCorpDaoImpl();
		return corpDao.queryCity(provinceId);
	}

	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		IQueryCorpDao corpDao = new QueryCorpDaoImpl();
		return corpDao.queryProvince();
	}

	@Override
	public List<CertifiedService> queryGradeCertifiedService(String check) {
		// TODO Auto-generated method stub
		IQueryCorpDao corpDao = new QueryCorpDaoImpl();
		return corpDao.queryGradeCertifiedService(check);
	}
	
	
}
