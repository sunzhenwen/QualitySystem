package com.tj.jst.inner.qualificationProductivity.queryCorp.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.queryCorp.dao.IQueryCorpApplyDao;
import com.tj.jst.inner.qualificationProductivity.queryCorp.dao.QueryCorpApplyDaoImpl;

/**
 * 查询企业所申报的资质信息服务类
 * 
 * @author Administrator
 *
 */
public class QueryCorpApplyServiceImpl implements IQueryCorpApplyService {

	/**
	 * 分页方法
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IQueryCorpApplyDao dao = new QueryCorpApplyDaoImpl();
		return dao.queryPage(condition);
	}

}
