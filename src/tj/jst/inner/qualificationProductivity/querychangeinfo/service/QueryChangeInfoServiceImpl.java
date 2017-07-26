package com.tj.jst.inner.qualificationProductivity.querychangeinfo.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;
import com.tj.jst.inner.qualificationProductivity.querychangeinfo.dao.IQueryChangeInfoDao;
import com.tj.jst.inner.qualificationProductivity.querychangeinfo.dao.QueryChangeInfoDaoImpl;

/**
 * ������ѯ�����ر��
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryChangeInfoServiceImpl implements IQueryChangeInfoService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IQueryChangeInfoDao dao = new QueryChangeInfoDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * ��ѯ��ϸ
	 */
	@Override
	public ChangeArea queryInfo(String changeId) {
		// TODO Auto-generated method stub
		IQueryChangeInfoDao dao = new QueryChangeInfoDaoImpl();
		return dao.queryInfo(changeId);
	}

}
