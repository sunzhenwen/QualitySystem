package com.tj.jst.outside.corpinto.performance.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.performance.model.Performance;

/**
 * 企业工程业绩
 * @author Administrator
 *
 */
public interface IPerformanceDao {
	
	//分页查询
	public Page pagedQuery(Condition condition);
	//添加
	public void add(Performance performance);
	//删除
	public void delete(String perId);
	//详细
	public Performance detailed(String perId);
}
