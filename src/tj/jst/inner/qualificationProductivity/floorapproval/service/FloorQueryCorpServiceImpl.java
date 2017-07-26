package com.tj.jst.inner.qualificationProductivity.floorapproval.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.floorapproval.dao.FloorQueryCorpDaoImpl;
import com.tj.jst.inner.qualificationProductivity.floorapproval.dao.IFloorQueryCorpDao;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 大厅查询企业信息服务类
 * 
 * @author Administrator
 *
 */
public class FloorQueryCorpServiceImpl implements IFloorQueryCorpService {

	/**
	 * 分页类
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IFloorQueryCorpDao dao = new FloorQueryCorpDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * 查询详细
	 */
	@Override
	public Corp queryInfo(String corpCode) {
		// TODO Auto-generated method stub
		IFloorQueryCorpDao dao = new FloorQueryCorpDaoImpl();
		return dao.queryInfo(corpCode);
	}

}
