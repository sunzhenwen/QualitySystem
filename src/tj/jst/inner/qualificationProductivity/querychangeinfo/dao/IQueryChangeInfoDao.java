package com.tj.jst.inner.qualificationProductivity.querychangeinfo.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;

/**
 * 内网查询归属地变更信息
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryChangeInfoDao {

	/**
	 * 分页类
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * 查询详细
	 * 
	 * @param changeId
	 * @return
	 */
	public ChangeArea queryInfo(String changeId);
}
