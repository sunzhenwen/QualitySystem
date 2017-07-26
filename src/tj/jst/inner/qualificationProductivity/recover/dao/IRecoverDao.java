package com.tj.jst.inner.qualificationProductivity.recover.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;

/**
 * 企业资质注销
 * @author Administrator
 *
 */
public interface IRecoverDao {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	public List<CertificatePrint> queryCertinfo(String[] ids);
	public void baseBatchRecover(List<CertificatePrint> list,String personalId,String personalName);
	public List<DictionaryClass> queryEconmicNums();
}
