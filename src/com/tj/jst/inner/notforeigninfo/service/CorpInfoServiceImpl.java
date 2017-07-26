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
	 * 企业名称查询
	 */
	@Override
	public String queryCorpName(CorpInfo corp) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryCorpName(corp);
	}

	/**
	 * 查询省
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryProvince();
	}

	/**
	 * 查询市
	 */
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryCity(provinceId);
	}

	/**
	 * 查询区
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryArea(cityId);
	}

	/**
	 * 字典：证件信息
	 */
	@Override
	public List<DictionaryClass> queryIdCardType() {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryIdCardType();
	}

	/**
	 * 字典：企业登记注册类型
	 */
	@Override
	public List<DictionaryClass> queryEconomicNum() {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryEconomicNum();
	}

	/**
	 * 字典：注册币种
	 */
	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryPrincipalUnit();
	}

	/**
	 * 保存企业信息
	 */
	@Override
	public String addCorp(CorpInfo corp) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.addCorp(corp);
	}

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.pagedQuery(condition);
	}

	/**
	 * 通过corpId来查询要修改的企业
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
	 * 修改企业信息
	 */
	@Override
	public String modify(CorpInfo corp) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.modify(corp);
	}

	/**
	 * 通过CorpId 和corpName 来判断所修改的企业名称是否重复
	 */
	@Override
	public String queryCorpInfoUsed(String corpId, String corpName) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		String message = "";
		message = corpInfoDao.queryCorpInfoUsed(corpId, corpName);
		if (message.equals("失败")) {
			return "对不起，您修改的证件信息：企业名称， 已经被使用，请核对您想要修改的信息！";
		} else {
			return "成功";
		}
	}

	@Override
	public CorpInfo queryByCode(String corpCode) {
		// TODO Auto-generated method stub
		ICorpInfoDao corpInfoDao = new CorpInfoDaoImpl();
		return corpInfoDao.queryByCode(corpCode);
	}

}
