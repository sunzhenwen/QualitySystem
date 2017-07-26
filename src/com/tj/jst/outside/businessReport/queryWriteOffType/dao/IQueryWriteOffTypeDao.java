package com.tj.jst.outside.businessReport.queryWriteOffType.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;

/**
 * ��ҵ����ע������״̬��ѯ
 * @author Administrator
 *
 */
public interface IQueryWriteOffTypeDao {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	public List<CertificatePrint> queryCertinfo(String[] ids);
	public void baseWriteOffApp(List<CertificatePrint> list);
	public List<DictionaryClass> queryEconmicNums();
}
