package com.tj.jst.outside.corpinto.foreign.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.foreign.dao.ForeignCorpDaoImpl;
import com.tj.jst.outside.corpinto.foreign.dao.IForeignCorpDao;
import com.tj.jst.outside.corpinto.foreign.model.ForeignCorp;


public class ForeignCorpServiceImpl implements IForeignCorpService{

	//组织机构代码查询
	@Override
	public ForeignCorp queryCorpName(String corpCode) {
		// TODO Auto-generated method stub
		IForeignCorpDao foreignCorpDao = new ForeignCorpDaoImpl();
		return foreignCorpDao.queryCorpName(corpCode);
	}

	//国籍或地区查询
	@Override
	public List<DictionaryClass> queryNation() {
		// TODO Auto-generated method stub
		IForeignCorpDao foreignCorpDao = new ForeignCorpDaoImpl();
		return foreignCorpDao.queryNation();
	}

	//投资币种查询
	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		// TODO Auto-generated method stub
		IForeignCorpDao foreignCorpDao = new ForeignCorpDaoImpl();
		return foreignCorpDao.queryPrincipalUnit();
	}

	//保存外资企业
	@Override
	public String addForeignCorp(ForeignCorp foreigncorp) {
		// TODO Auto-generated method stub
		IForeignCorpDao foreginCropDao = new ForeignCorpDaoImpl();
		return foreginCropDao.addForeignCorp(foreigncorp);
	}

	//修改外资企业
	@Override
	public String modifyForeignCorp(ForeignCorp foreigncorp) {
		// TODO Auto-generated method stub
		IForeignCorpDao foreginCropDao = new ForeignCorpDaoImpl();
		return foreginCropDao.modifyForeignCorp(foreigncorp);
	}

	//投资人类型
	@Override
	public List<DictionaryClass> queryIvestor() {
		// TODO Auto-generated method stub
		IForeignCorpDao foreignCorpDao = new ForeignCorpDaoImpl();
		return foreignCorpDao.queryIvestor();
	}


	
	

}
