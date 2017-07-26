package com.tj.jst.inner.qualificationProductivity.queryfloorapproval.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;

/**
 * 历史大厅办理查询接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryFloorApprovalService {

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
