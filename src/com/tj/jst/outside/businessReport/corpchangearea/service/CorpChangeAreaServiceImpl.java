package com.tj.jst.outside.businessReport.corpchangearea.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;
import com.tj.jst.outside.businessReport.corpchangearea.dao.CorpChangeAreaDaoImpl;
import com.tj.jst.outside.businessReport.corpchangearea.dao.ICorpChangeAreaDao;

/**
 * 企业跨地市变更申请
 * 
 * @author DarkFlameMaster
 *
 */
public class CorpChangeAreaServiceImpl implements ICorpChangeAreaService {

	/**
	 * 查询企业信息
	 */
	@Override
	public CertifiedCorp queryPage(String corpName) {
		// TODO Auto-generated method stub
		ICorpChangeAreaDao dao = new CorpChangeAreaDaoImpl();
		return dao.queryPage(corpName);
	}

	/**
	 * 企业提交申请
	 */
	@Override
	public String approvalUpdate(ChangeArea change , int mark) {
		// TODO Auto-generated method stub
		ICorpChangeAreaDao dao = new CorpChangeAreaDaoImpl();
		return dao.approvalUpdate(change,mark);
	}

	/**
	 * 查询省
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		ICorpChangeAreaDao dao = new CorpChangeAreaDaoImpl();
		return dao.queryProvince();
	}

	/**
	 * 查询市
	 */
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
		ICorpChangeAreaDao dao = new CorpChangeAreaDaoImpl();
		return dao.queryCity(provinceId);
	}

	/**
	 * 查询是否需要厅局审批
	 */
	@Override
	public String queryMark(String corpName) {
		// TODO Auto-generated method stub
		ICorpChangeAreaDao dao = new CorpChangeAreaDaoImpl();
		return dao.queryMark(corpName);
	}

}
