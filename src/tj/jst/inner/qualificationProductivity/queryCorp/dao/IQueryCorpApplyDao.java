package com.tj.jst.inner.qualificationProductivity.queryCorp.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * 查询企业所申报的资质信息 数据库接口
 * 
 * @author Administrator
 *
 */
public interface IQueryCorpApplyDao {

	/**
	 * 分页方法
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

}
