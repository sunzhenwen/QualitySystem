package com.tj.jst.outside.businessReport.corpchangearea.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;
import com.tj.jst.outside.businessReport.corpchangearea.dao.CorpChangeAreaDaoImpl;
import com.tj.jst.outside.businessReport.corpchangearea.dao.ICorpChangeAreaDao;

/**
 * ��ҵ����б������
 * 
 * @author DarkFlameMaster
 *
 */
public class CorpChangeAreaServiceImpl implements ICorpChangeAreaService {

	/**
	 * ��ѯ��ҵ��Ϣ
	 */
	@Override
	public CertifiedCorp queryPage(String corpName) {
		// TODO Auto-generated method stub
		ICorpChangeAreaDao dao = new CorpChangeAreaDaoImpl();
		return dao.queryPage(corpName);
	}

	/**
	 * ��ҵ�ύ����
	 */
	@Override
	public String approvalUpdate(ChangeArea change , int mark) {
		// TODO Auto-generated method stub
		ICorpChangeAreaDao dao = new CorpChangeAreaDaoImpl();
		return dao.approvalUpdate(change,mark);
	}

	/**
	 * ��ѯʡ
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		ICorpChangeAreaDao dao = new CorpChangeAreaDaoImpl();
		return dao.queryProvince();
	}

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
		ICorpChangeAreaDao dao = new CorpChangeAreaDaoImpl();
		return dao.queryCity(provinceId);
	}

	/**
	 * ��ѯ�Ƿ���Ҫ��������
	 */
	@Override
	public String queryMark(String corpName) {
		// TODO Auto-generated method stub
		ICorpChangeAreaDao dao = new CorpChangeAreaDaoImpl();
		return dao.queryMark(corpName);
	}

}
