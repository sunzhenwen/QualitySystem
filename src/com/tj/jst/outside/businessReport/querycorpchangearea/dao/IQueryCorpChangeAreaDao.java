package com.tj.jst.outside.businessReport.querycorpchangearea.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * 企业查询归属地变更Dao接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryCorpChangeAreaDao {

	/**
	 * 分页类
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * 删除类
	 * 
	 * @param changeId
	 * @return
	 */
	public String deleteChange(String changeId);

}
