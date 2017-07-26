package com.tj.jst.inner.qualificationProductivity.floorapproval.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 大厅查询企业信息服务接口
 * 
 * @author Administrator
 *
 */
public interface IFloorQueryCorpService {

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
