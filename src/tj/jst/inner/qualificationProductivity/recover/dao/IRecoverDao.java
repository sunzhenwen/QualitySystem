package com.tj.jst.inner.qualificationProductivity.recover.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;

/**
 * ��ҵ����ע��
 * @author Administrator
 *
 */
public interface IRecoverDao {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	public List<CertificatePrint> queryCertinfo(String[] ids);
	public void baseBatchRecover(List<CertificatePrint> list,String personalId,String personalName);
	public List<DictionaryClass> queryEconmicNums();
}
