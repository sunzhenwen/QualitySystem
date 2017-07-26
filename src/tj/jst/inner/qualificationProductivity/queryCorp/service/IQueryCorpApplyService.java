package com.tj.jst.inner.qualificationProductivity.queryCorp.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * 查询企业所申报的资质信息服务接口
 * 
 * @author Administrator
 *
 */
public interface IQueryCorpApplyService {

	/**
	 * 分页方法
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

}
