package com.tj.jst.outside.businessReport.queryWriteOffType.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.certificatePrint.model.CertificatePrint;
import com.tj.jst.outside.businessReport.queryWriteOffType.dao.IQueryWriteOffTypeDao;
import com.tj.jst.outside.businessReport.queryWriteOffType.dao.QueryWriteOffTypeDaoImpl;
import com.tj.jst.outside.businessReport.writeOffApproval.dao.IWriteOffApprovalDao;
import com.tj.jst.outside.businessReport.writeOffApproval.dao.WriteOffApprovalDaoImpl;

/**
 * ��ҵ����ע������״̬��ѯ
 * @author Administrator
 *
 */
public class QueryWriteOffTypeServiceImpl implements IQueryWriteOffTypeService {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryWriteOffTypeDao dao = new QueryWriteOffTypeDaoImpl();
		return dao.pagedQuery(condition);
	}
	
	/**
	 * ��������
	 * @return
	 */
	public void baseWriteOffApp(String[] ids)
	{
		IQueryWriteOffTypeDao dao = new QueryWriteOffTypeDaoImpl();
		List<CertificatePrint> list = dao.queryCertinfo(ids);
		dao.baseWriteOffApp(list);
	}
	@Override
	public List<DictionaryClass> queryEconmicNums() {
		IQueryWriteOffTypeDao dao = new QueryWriteOffTypeDaoImpl();
		return dao.queryEconmicNums();
	}
}
