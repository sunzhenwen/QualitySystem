package com.tj.jst.inner.notforeign.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.dao.CertifiedCorpDaoImpl;
import com.tj.jst.inner.notforeign.dao.ICertifiedCorpDao;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;


public class CertifiedCorpServiceImpl implements ICertifiedCorpService {

	
	//证件类型
	@Override
	public List<DictionaryClass> queryIdCardType() {
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.queryIdCardType();
	}

	//修改企业
	@Override
	public String modifyCorp(CertifiedCorp corp) {
		// TODO Auto-generated method stub
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.modifyCorp(corp);
	}

	//查询企业信息
	@Override
	public CertifiedCorp queryCorp(String corpName) {
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.queryCorp(corpName);
	}

	/**
	 * 企业资质是否就位判断
	 */
	@Override
	public String perchCheck(String corpId) {
		// TODO Auto-generated method stub
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.perchCheck(corpId);
	}

	/**
	 * 未就位企业信息修改
	 */
	@Override
	public String modifyCorpTwo(CertifiedCorp corp) {
		// TODO Auto-generated method stub
		ICertifiedCorpDao corpDao = new CertifiedCorpDaoImpl();
		return corpDao.modifyCorpTwo(corp);
	}

	/**
	 * 组织机构代码证判断
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
