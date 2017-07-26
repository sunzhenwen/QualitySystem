package com.tj.jst.inner.notforeign.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.dao.CertifiedCorpDaoImpl;
import com.tj.jst.inner.notforeign.dao.ICertifiedCorpDao;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;


public class CertifiedCorpServiceImpl implements ICertifiedCorpService {

	
	//֤������
	@Override
	public List<DictionaryClass> queryIdCardType() {
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.queryIdCardType();
	}

	//�޸���ҵ
	@Override
	public String modifyCorp(CertifiedCorp corp) {
		// TODO Auto-generated method stub
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.modifyCorp(corp);
	}

	//��ѯ��ҵ��Ϣ
	@Override
	public CertifiedCorp queryCorp(String corpName) {
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.queryCorp(corpName);
	}

	/**
	 * ��ҵ�����Ƿ��λ�ж�
	 */
	@Override
	public String perchCheck(String corpId) {
		// TODO Auto-generated method stub
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.perchCheck(corpId);
	}

	/**
	 * δ��λ��ҵ��Ϣ�޸�
	 */
	@Override
	public String modifyCorpTwo(CertifiedCorp corp) {
		// TODO Auto-generated method stub
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.modifyCorpTwo(corp);
	}

	/**
	 * ��֯��������֤�ж�
	 */
	@Override
	public String queryCorpCode(CertifiedCorp corp) {
		// TODO Auto-generated method stub
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.queryCorpCode(corp);
	}

	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.queryProvince();
	}

	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.queryCity(provinceId);
	}

	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.queryArea(cityId);
	}

	@Override
	public List<DictionaryClass> queryEconomicNum() {
		// TODO Auto-generated method stub
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.queryEconomicNum();
	}

	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		// TODO Auto-generated method stub
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.queryPrincipalUnit();
	}
	
}
