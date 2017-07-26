package com.tj.jst.outside.businessReport.writeOffApproval.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;
import com.tj.jst.outside.businessReport.writeOffApproval.dao.IWriteOffApprovalDao;
import com.tj.jst.outside.businessReport.writeOffApproval.dao.WriteOffApprovalDaoImpl;

/**
 * ��ҵ����ע������
 * @author Administrator
 *
 */
public class WriteOffApprovalServiceImpl implements IWriteOffApprovalService {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IWriteOffApprovalDao dao = new WriteOffApprovalDaoImpl();
		return dao.pagedQuery(condition);
	}
	
	/**
	 * ��������
	 * @return
	 */
	public void baseWriteOffApp(String[] ids)
	{
		IWriteOffApprovalDao dao = new WriteOffApprovalDaoImpl();
		List<CertificatePrint> list = dao.queryCertinfo(ids);
		dao.baseWriteOffApp(list);
	}
	@Override
	public List<DictionaryClass> queryEconmicNums() {
		IWriteOffApprovalDao dao = new WriteOffApprovalDaoImpl();
		return dao.queryEconmicNums();
	}
}
