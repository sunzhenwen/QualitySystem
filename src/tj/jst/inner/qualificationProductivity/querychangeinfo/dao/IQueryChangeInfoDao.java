package com.tj.jst.inner.qualificationProductivity.querychangeinfo.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;

/**
 * ������ѯ�����ر����Ϣ
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryChangeInfoDao {

	/**
	 * ��ҳ��
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * ��ѯ��ϸ
	 * 
	 * @param changeId
	 * @return
	 */
	public ChangeArea queryInfo(String changeId);
}
