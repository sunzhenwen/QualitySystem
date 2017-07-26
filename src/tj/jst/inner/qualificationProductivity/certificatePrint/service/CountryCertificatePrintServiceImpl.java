package com.tj.jst.inner.qualificationProductivity.certificatePrint.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.dao.CountryCertificatePrintDaoImpl;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.dao.ICountryCertificatePrintDao;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;

/**
 * 国家级别确认
 * @author hhc
 *
 */
public class CountryCertificatePrintServiceImpl implements ICountryCertificatePrintService {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICountryCertificatePrintDao dao = new CountryCertificatePrintDaoImpl();
		return dao.pagedQuery(condition);
	}

	@Override
	public List<DictionaryClass> queryEconmicNums() {
		ICountryCertificatePrintDao dao = new CountryCertificatePrintDaoImpl();
		return dao.queryEconmicNums();
	}
	public CertificatePrint confirmPage(String corpId,String certName)
	{
		ICountryCertificatePrintDao dao = new CountryCertificatePrintDaoImpl();
		return dao.confirmPage(corpId,certName);
	}

	@Override
	public void confirm(CertificatePrint countryPrint) {
		ICountryCertificatePrintDao dao = new CountryCertificatePrintDaoImpl();
		dao.confirm(countryPrint);
	}
	
	public void confirmBack(CertificatePrint countryPrint)
	{
		ICountryCertificatePrintDao dao = new CountryCertificatePrintDaoImpl();
		dao.confirmBack(countryPrint);
	}
}
