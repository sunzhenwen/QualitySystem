package com.tj.jst.inner.qualificationProductivity.recover.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;
import com.tj.jst.inner.qualificationProductivity.recover.dao.IRecoverDao;
import com.tj.jst.inner.qualificationProductivity.recover.dao.RecoverDaoImpl;

/**
 * ��ҵ���ʻָ�
 * @author Administrator
 *
 */
public class RecoverServiceImpl implements IRecoverService {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IRecoverDao dao = new RecoverDaoImpl();
		return dao.pagedQuery(condition);
	}
	
	/**
	 * ��������
	 * @return
	 */
	public void baseBatchRecover(String[] ids,String personalId,String personalName)
	{
		IRecoverDao dao = new RecoverDaoImpl();
		List<CertificatePrint> list = dao.queryCertinfo(ids);
		dao.baseBatchRecover(list,personalId,personalName);
	}
	@Override
	public List<DictionaryClass> queryEconmicNums() {
		IRecoverDao dao = new RecoverDaoImpl();
		return dao.queryEconmicNums();
	}
}
