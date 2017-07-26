package com.tj.jst.inner.qualificationProductivity.floorapproval.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ������ѯ��ҵ��Ϣ���ݿ�ӿ�
 * 
 * @author Administrator
 *
 */
public interface IFloorQueryCorpDao {

	/**
	 * ��ҳ��
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * ��ѯ��ϸ��Ϣ
	 * 
	 * @param corpCode
	 * @return
	 */
	public Corp queryInfo(String corpCode);

}
