package com.tj.jst.inner.qualificationProductivity.queryfloorapproval.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;
import com.tj.jst.inner.qualificationProductivity.queryfloorapproval.dao.IQueryFloorApprovalDao;
import com.tj.jst.inner.qualificationProductivity.queryfloorapproval.dao.QueryFloorApprovalDaoImpl;

/**
 * ��ʷ���������ѯ
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryFloorApprovalServiceImpl implements
		IQueryFloorApprovalService {

	/**
	 * ��ҳ��
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IQueryFloorApprovalDao dao = new QueryFloorApprovalDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * �鿴��ϸ
	 */
	@Override
	public FloorApproval queryInfo(String id) {
		// TODO Auto-generated method stub
		IQueryFloorApprovalDao dao = new QueryFloorApprovalDaoImpl();
		return dao.queryInfo(id);
	}

}
