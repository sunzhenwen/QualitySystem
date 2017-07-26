package com.tj.jst.inner.foreign.service;

import com.tj.jst.inner.foreign.dao.CertifiedForeignDaoImpl;
import com.tj.jst.inner.foreign.dao.ICertifiedForeignCorpDao;
import com.tj.jst.inner.foreign.model.CertifiedForeignCorp;

public class CertifiedForeignCorpServiceImpl implements ICertifiedForeignCorpService {

	/**
	 * 外商企业信息查询
	 */
	@Override
	public CertifiedForeignCorp queryCorp(String corpId) {
		// TODO Auto-generated method stub
		ICertifiedForeignCorpDao foreignDao = new CertifiedForeignDaoImpl();
		return foreignDao.queryCorp(corpId);
	}

	/**
	 * 外商企业信息修改
	 */
	@Override
	public String modifyCorp(CertifiedForeignCorp corp) {
		// TODO Auto-generated method stub
		ICertifiedForeignCorpDao foreignDao = new CertifiedForeignDaoImpl();
		return foreignDao.modifyCorp(corp);
	}

}
