package com.tj.jst.inner.qualificationProductivity.queryfloorapproval.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;

/**
 * ��ʷ���������ѯ���ݿ�ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryFloorApprovalDao {

	/**
	 * ��ҳ��
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * ��ѯ������Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public FloorApproval queryInfo(String id);

}
