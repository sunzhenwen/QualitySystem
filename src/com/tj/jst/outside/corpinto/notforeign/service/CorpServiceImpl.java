package com.tj.jst.outside.corpinto.notforeign.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.dao.CorpDaoImpl;
import com.tj.jst.outside.corpinto.notforeign.dao.ICorpDao;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;


public class CorpServiceImpl implements ICorpService {

	//企业名称查询
	@Override
	public Corp queryCorpName(String corpCode) {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryCorpName(corpCode);
	}

	//查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryProvince();
	}

	//查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryCity(provinceId);
	}

	//证件类型
	@Override
	public List<DictionaryClass> queryIdCardType() {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryIdCardType();
	}

	//企业登记注册类型
	@Override
	public List<DictionaryClass> queryEconomicNum() {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryEconomicNum();
	}

	//注册资本币种
	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryPrincipalUnit();
	}

	//保存企业
	@Override
	public String addCorp(Corp corp) {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.addCorp(corp);
	}

	//修改企业
	@Override
	public String modifyCorp(Corp corp) {
		// TODO Auto-generated method stub
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.modifyCorp(corp);
	}

	//查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryArea(cityId);
	}

	//查询黑龙江省所有市
	@Override
	public List<DictionaryClass> queryHLJCitys() {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryHLJCitys();
	}
	
}
