package com.tj.jst.outside.corpinto.performance.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.performance.model.Performance;

/**
 * ��ҵ����ҵ��
 * @author Administrator
 *
 */
public interface IPerformanceService {
	
	//��ҳ��ѯ
	public Page pagedQuery(Condition condition);
	
	//���
	public void add(Performance performance);
	//ɾ��
	public void delete(String perId);
	//��ϸ
	public Performance detailed(String perId);
}
