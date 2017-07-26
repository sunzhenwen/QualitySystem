package com.tj.jst.inner.qualificationProductivity.queryfloorapproval.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;

/**
 * ��ʷ���������ѯ�ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryFloorApprovalService {

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
