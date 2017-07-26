package com.tj.jst.outside.corpinto.foreign.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.foreign.dao.ForeignCorpDaoImpl;
import com.tj.jst.outside.corpinto.foreign.dao.IForeignCorpDao;
import com.tj.jst.outside.corpinto.foreign.model.ForeignCorp;


public class ForeignCorpServiceImpl implements IForeignCorpService{

	//��֯���������ѯ
	@Override
	public ForeignCorp queryCorpName(String corpCode) {
		// TODO Auto-generated method stub
		IForeignCorpDao foreignCorpDao = new ForeignCorpDaoImpl();
		return foreignCorpDao.queryCorpName(corpCode);
	}

	//�����������ѯ
	@Override
	public List<DictionaryClass> queryNation() {
		// TODO Auto-generated method stub
		IForeignCorpDao foreignCorpDao = new ForeignCorpDaoImpl();
		return foreignCorpDao.queryNation();
	}

	//Ͷ�ʱ��ֲ�ѯ
	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		// TODO Auto-generated method stub
		IForeignCorpDao foreignCorpDao = new ForeignCorpDaoImpl();
		return foreignCorpDao.queryPrincipalUnit();
	}

	//����������ҵ
	@Override
	public String addForeignCorp(ForeignCorp foreigncorp) {
		// TODO Auto-generated method stub
		IForeignCorpDao foreginCropDao = new ForeignCorpDaoImpl();
		return foreginCropDao.addForeignCorp(foreigncorp);
	}

	//�޸�������ҵ
	@Override
	public String modifyForeignCorp(ForeignCorp foreigncorp) {
		// TODO Auto-generated method stub
		IForeignCorpDao foreginCropDao = new ForeignCorpDaoImpl();
		return foreginCropDao.modifyForeignCorp(foreigncorp);
	}

	//Ͷ��������
	@Override
	public List<DictionaryClass> queryIvestor() {
		// TODO Auto-generated method stub
		IForeignCorpDao foreignCorpDao = new ForeignCorpDaoImpl();
		return foreignCorpDao.queryIvestor();
	}


	
	

}
