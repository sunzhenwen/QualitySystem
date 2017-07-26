package com.tj.jst.outside.businessReport.querycorpchangearea.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * 查询归属地变更服务接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryCorpChangeAreaService {

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
