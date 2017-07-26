package com.tj.jst.inner.qualificationProductivity.certificatePrint.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.dao.CityCertificatePrintDaoImpl;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.dao.ICityCertificatePrintDao;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;

/**
 * 地市证书打印
 * @author hhc
 *
 */
public class CityCertificatePrintServiceImpl implements ICityCertificatePrintService {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICityCertificatePrintDao dao = new CityCertificatePrintDaoImpl();
		return dao.pagedQuery(condition);
	}

	@Override
	public List<DictionaryClass> queryEconmicNums() {
		ICityCertificatePrintDao dao = new CityCertificatePrintDaoImpl();
		return dao.queryEconmicNums();
	}
	@Override
	public CertificatePrint queryPrint(String corpName) {
		ICityCertificatePrintDao dao = new CityCertificatePrintDaoImpl();
		return dao.queryPrint(corpName);
	}

	@Override
	public void updateCertificateNumber(String certid, String type,
			String number) {
		ICityCertificatePrintDao dao = new CityCertificatePrintDaoImpl();
		dao.updateCertificateNumber(certid, type, number);
	}
}
