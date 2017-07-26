package com.tj.jst.inner.notforeigninfo.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeigninfo.dao.CorpInfoDaoImpl;
import com.tj.jst.inner.notforeigninfo.dao.ICorpInfoDao;
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;

public class CorpInfoServiceImpl implements ICorpInfoService {

	/**
	 * ��ҵ���Ʋ�ѯ
	 */
	@Override
	public String queryCorpName(CorpInfo corp) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryCorpName(corp);
	}

	/**
	 * ��ѯʡ
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryProvince();
	}

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryCity(provinceId);
	}

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryArea(cityId);
	}

	/**
	 * �ֵ䣺֤����Ϣ
	 */
	@Override
	public List<DictionaryClass> queryIdCardType() {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryIdCardType();
	}

	/**
	 * �ֵ䣺��ҵ�Ǽ�ע������
	 */
	@Override
	public List<DictionaryClass> queryEconomicNum() {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryEconomicNum();
	}

	/**
	 * �ֵ䣺ע�����
	 */
	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryPrincipalUnit();
	}

	/**
	 * ������ҵ��Ϣ
	 */
	@Override
	public String addCorp(CorpInfo corp) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.addCorp(corp);
	}

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.pagedQuery(condition);
	}

	/**
	 * ͨ��corpId����ѯҪ�޸ĵ���ҵ
	 */
	@Override
	public CorpInfo queryById(String corpId) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		CorpInfo corp = new CorpInfo();
		corp = corpInfoDao.queryById(corpId);
		return corp;
	}

	/**
	 * �޸���ҵ��Ϣ
	 */
	@Override
	public String modify(CorpInfo corp) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.modify(corp);
	}

	/**
	 * ͨ��CorpId ��corpName ���ж����޸ĵ���ҵ�����Ƿ��ظ�
	 */
	@Override
	public String queryCorpInfoUsed(String corpId, String corpName) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		String message = "";
		message = corpInfoDao.queryCorpInfoUsed(corpId, corpName);
		if (message.equals("ʧ��")) {
			return "�Բ������޸ĵ�֤����Ϣ����ҵ���ƣ� �Ѿ���ʹ�ã���˶�����Ҫ�޸ĵ���Ϣ��";
		} else {
			return "�ɹ�";
		}
	}

	@Override
	public CorpInfo queryByCode(String corpCode) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryByCode(corpCode);
	}

}
