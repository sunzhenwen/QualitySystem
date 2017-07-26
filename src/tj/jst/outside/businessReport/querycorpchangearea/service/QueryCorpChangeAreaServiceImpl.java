package com.tj.jst.outside.businessReport.querycorpchangearea.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.businessReport.querycorpchangearea.dao.IQueryCorpChangeAreaDao;
import com.tj.jst.outside.businessReport.querycorpchangearea.dao.QueryCorpChangeAreaDaoImpl;

/**
 * 企业查询归属地变更服务类
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryCorpChangeAreaServiceImpl implements
		IQueryCorpChangeAreaService {

	/**
	 * 分页查询
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IQueryCorpChangeAreaDao dao = new QueryCorpChangeAreaDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * 删除条目
	 */
	@Override
	public String deleteChange(String changeId) {
		// TODO Auto-generated method stub
		IQueryCorpChangeAreaDao dao = new QueryCorpChangeAreaDaoImpl();
		return dao.deleteChange(changeId);
	}

}
