package com.tj.jst.inner.qualificationProductivity.floorapproval.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.floorapproval.dao.FloorQueryCorpDaoImpl;
import com.tj.jst.inner.qualificationProductivity.floorapproval.dao.IFloorQueryCorpDao;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ������ѯ��ҵ��Ϣ������
 * 
 * @author Administrator
 *
 */
public class FloorQueryCorpServiceImpl implements IFloorQueryCorpService {

	/**
	 * ��ҳ��
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IFloorQueryCorpDao dao = new FloorQueryCorpDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * ��ѯ��ϸ
	 */
	@Override
	public Corp queryInfo(String corpCode) {
		// TODO Auto-generated method stub
		IFloorQueryCorpDao dao = new FloorQueryCorpDaoImpl();
		return dao.queryInfo(corpCode);
	}

}
