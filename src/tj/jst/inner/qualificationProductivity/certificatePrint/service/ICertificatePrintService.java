package com.tj.jst.inner.qualificationProductivity.certificatePrint.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;

/**
 * ֤���ӡ
 * @author hhc
 *
 */
public interface ICertificatePrintService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	public List<DictionaryClass> queryEconmicNums();
	public CertificatePrint queryPrint(String corpName);
	public void updateCertificateNumber(String certid,String type,String number);

}
