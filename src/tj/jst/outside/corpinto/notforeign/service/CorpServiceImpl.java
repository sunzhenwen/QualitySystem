package com.tj.jst.outside.corpinto.notforeign.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.dao.CorpDaoImpl;
import com.tj.jst.outside.corpinto.notforeign.dao.ICorpDao;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;


public class CorpServiceImpl implements ICorpService {

	//��ҵ���Ʋ�ѯ
	@Override
	public Corp queryCorpName(String corpCode) {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryCorpName(corpCode);
	}

	//��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryProvince();
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryCity(provinceId);
	}

	//֤������
	@Override
	public List<DictionaryClass> queryIdCardType() {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryIdCardType();
	}

	//��ҵ�Ǽ�ע������
	@Override
	public List<DictionaryClass> queryEconomicNum() {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryEconomicNum();
	}

	//ע���ʱ�����
	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryPrincipalUnit();
	}

	//������ҵ
	@Override
	public String addCorp(Corp corp) {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.addCorp(corp);
	}

	//�޸���ҵ
	@Override
	public String modifyCorp(Corp corp) {
		// TODO Auto-generated method stub
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.modifyCorp(corp);
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryArea(cityId);
	}

	//��ѯ������ʡ������
	@Override
	public List<DictionaryClass> queryHLJCitys() {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryHLJCitys();
	}
	
}
