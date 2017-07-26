package com.tj.jst.inner.qualificationProductivity.innerchangearea.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.dao.IInnerChangeAreaDao;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.dao.InnerChangeAreaDaoImpl;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.model.InnerChangeArea;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 内网主动修改企业归属地服务方法
 * 
 * @author DarkFlameMaster
 *
 */
public class InnerChangeAreaServiceImpl implements IInnerChangeAreaService {

	/**
	 * 分页查询
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IInnerChangeAreaDao dao = new InnerChangeAreaDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * 查询企业信息
	 */
	@Override
	public Corp queryCorp(String corpCode) {
		// TODO Auto-generated method stub
		IInnerChangeAreaDao dao = new InnerChangeAreaDaoImpl();
		return dao.queryCorp(corpCode);
	}

	/**
	 * 更改企业归属地
	 */
	@Override
	public String changeArea(String corpCode, String cityNum) {
		// TODO Auto-generated method stub
		IInnerChangeAreaDao dao = new InnerChangeAreaDaoImpl();
		return dao.changeArea(corpCode, cityNum);
	}

	/**
	 * 记录操作日志
	 */
	@Override
	public String recordLog(InnerChangeArea info) {
		// TODO Auto-generated method stub
		IInnerChangeAreaDao dao = new InnerChangeAreaDaoImpl();
		return dao.recordLog(info);
	}

	/**
	 * 日志查询
	 */
	@Override
	public Page queryInfoPage(Condition condition) {
		// TODO Auto-generated method stub
		IInnerChangeAreaDao dao = new InnerChangeAreaDaoImpl();
		return dao.queryInfoPage(condition);
	}

}
