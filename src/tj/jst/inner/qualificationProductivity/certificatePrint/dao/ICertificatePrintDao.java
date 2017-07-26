package com.tj.jst.inner.qualificationProductivity.certificatePrint.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;

/**
 * 证书打印
 * @author hhc
 *
 */
public interface ICertificatePrintDao {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	public List<DictionaryClass> queryEconmicNums();
	public CertificatePrint queryPrint(String corpCode);
	public void updateCertificateNumber(String certid,String type,String number);
}
