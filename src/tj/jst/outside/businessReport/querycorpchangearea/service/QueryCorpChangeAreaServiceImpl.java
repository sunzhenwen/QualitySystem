package com.tj.jst.outside.businessReport.querycorpchangearea.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.businessReport.querycorpchangearea.dao.IQueryCorpChangeAreaDao;
import com.tj.jst.outside.businessReport.querycorpchangearea.dao.QueryCorpChangeAreaDaoImpl;

/**
 * ��ҵ��ѯ�����ر��������
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryCorpChangeAreaServiceImpl implements
		IQueryCorpChangeAreaService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IQueryCorpChangeAreaDao dao = new QueryCorpChangeAreaDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * ɾ����Ŀ
	 */
	@Override
	public String deleteChange(String changeId) {
		// TODO Auto-generated method stub
		IQueryCorpChangeAreaDao dao = new QueryCorpChangeAreaDaoImpl();
		return dao.deleteChange(changeId);
	}

}
