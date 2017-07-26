package com.tj.jst.inner.qualificationProductivity.certificatePrint.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.dao.CertificatePrintDaoImpl;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.dao.ICertificatePrintDao;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;

/**
 * 证书打印
 * @author hhc
 *
 */
public class CertificatePrintServiceImpl implements ICertificatePrintService {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICertificatePrintDao dao = new CertificatePrintDaoImpl();
		return dao.pagedQuery(condition);
	}

	@Override
	public List<DictionaryClass> queryEconmicNums() {
		ICertificatePrintDao dao = new CertificatePrintDaoImpl();
		return dao.queryEconmicNums();
	}

	@Override
	public CertificatePrint queryPrint(String corpName) {
		ICertificatePrintDao dao = new CertificatePrintDaoImpl();
		return dao.queryPrint(corpName);
	}

	@Override
	public void updateCertificateNumber(String certid, String type,
			String number) {
		ICertificatePrintDao dao = new CertificatePrintDaoImpl();
		dao.updateCertificateNumber(certid, type, number);
		
	}
	
}
