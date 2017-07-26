package com.tj.jst.inner.qualificationProductivity.queryfloorapproval.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;

/**
 * 历史大厅办理查询数据库接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryFloorApprovalDao {

	/**
	 * 分页类
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * 查询审批信息
	 * 
	 * @param id
	 * @return
	 */
	public FloorApproval queryInfo(String id);

}
