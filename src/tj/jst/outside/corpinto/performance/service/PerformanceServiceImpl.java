package com.tj.jst.outside.corpinto.performance.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.performance.dao.IPerformanceDao;
import com.tj.jst.outside.corpinto.performance.dao.PerformanceDaoImpl;
import com.tj.jst.outside.corpinto.performance.model.Performance;

/**
 * 企业工程业绩
 * @author Administrator
 *
 */
public class PerformanceServiceImpl implements IPerformanceService {

	//分页查询
	@Override
	public Page pagedQuery(Condition condition) {
		IPerformanceDao dao = new PerformanceDaoImpl();
		return dao.pagedQuery(condition);
	}

	//添加
	@Override
	public void add(Performance performance) {
		// TODO Auto-generated method stub
		IPerformanceDao dao = new PerformanceDaoImpl();
		dao.add(performance);
	}

	//删除
	@Override
	public void delete(String perId) {
		// TODO Auto-generated method stub
		IPerformanceDao dao = new PerformanceDaoImpl();
		dao.delete(perId);
	}

	//详细
	@Override
	public Performance detailed(String perId) {
		// TODO Auto-generated method stub
		IPerformanceDao dao = new PerformanceDaoImpl();
		return dao.detailed(perId);
	}
}
