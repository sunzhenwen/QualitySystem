package com.tj.jst.inner.qualificationProductivity.certificatePrint.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;

/**
 * 国家级别确认
 * @author hhc
 *
 */
public interface ICountryCertificatePrintService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	public List<DictionaryClass> queryEconmicNums();
	
	public CertificatePrint confirmPage(String corpId, String certName);
	
	public void confirm(CertificatePrint countryPrint);
	public void confirmBack(CertificatePrint countryPrint);
}
