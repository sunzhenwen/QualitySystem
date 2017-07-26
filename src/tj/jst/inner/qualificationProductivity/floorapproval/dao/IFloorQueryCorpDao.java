package com.tj.jst.inner.qualificationProductivity.floorapproval.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 大厅查询企业信息数据库接口
 * 
 * @author Administrator
 *
 */
public interface IFloorQueryCorpDao {

	/**
	 * 分页类
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * 查询详细信息
	 * 
	 * @param corpCode
	 * @return
	 */
	public Corp queryInfo(String corpCode);

}
