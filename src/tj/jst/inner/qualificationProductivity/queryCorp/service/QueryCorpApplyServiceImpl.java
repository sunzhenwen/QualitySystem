package com.tj.jst.inner.qualificationProductivity.queryCorp.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.queryCorp.dao.IQueryCorpApplyDao;
import com.tj.jst.inner.qualificationProductivity.queryCorp.dao.QueryCorpApplyDaoImpl;

/**
 * ��ѯ��ҵ���걨��������Ϣ������
 * 
 * @author Administrator
 *
 */
public class QueryCorpApplyServiceImpl implements IQueryCorpApplyService {

	/**
	 * ��ҳ����
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IQueryCorpApplyDao dao = new QueryCorpApplyDaoImpl();
		return dao.queryPage(condition);
	}

}
