package com.tj.jst.outside.corpinto.performance.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.performance.dao.IPerformanceDao;
import com.tj.jst.outside.corpinto.performance.dao.PerformanceDaoImpl;
import com.tj.jst.outside.corpinto.performance.model.Performance;

/**
 * ��ҵ����ҵ��
 * @author Administrator
 *
 */
public class PerformanceServiceImpl implements IPerformanceService {

	//��ҳ��ѯ
	@Override
	public Page pagedQuery(Condition condition) {
		IPerformanceDao dao = new PerformanceDaoImpl();
		return dao.pagedQuery(condition);
	}

	//���
	@Override
	public void add(Performance performance) {
		// TODO Auto-generated method stub
		IPerformanceDao dao = new PerformanceDaoImpl();
		dao.add(performance);
	}

	//ɾ��
	@Override
	public void delete(String perId) {
		// TODO Auto-generated method stub
		IPerformanceDao dao = new PerformanceDaoImpl();
		dao.delete(perId);
	}

	//��ϸ
	@Override
	public Performance detailed(String perId) {
		// TODO Auto-generated method stub
		IPerformanceDao dao = new PerformanceDaoImpl();
		return dao.detailed(perId);
	}
}
