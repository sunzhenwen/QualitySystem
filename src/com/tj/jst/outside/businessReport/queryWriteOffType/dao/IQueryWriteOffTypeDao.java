package com.tj.jst.outside.businessReport.queryWriteOffType.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;

/**
 * 企业资质注销申请状态查询
 * @author Administrator
 *
 */
public interface IQueryWriteOffTypeDao {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	public List<CertificatePrint> queryCertinfo(String[] ids);
	public void baseWriteOffApp(List<CertificatePrint> list);
	public List<DictionaryClass> queryEconmicNums();
}
