package com.tj.jst.outside.businessReport.querycorpchangearea.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * ��ҵ��ѯ�����ر��Dao�ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryCorpChangeAreaDao {

	/**
	 * ��ҳ��
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * ɾ����
	 * 
	 * @param changeId
	 * @return
	 */
	public String deleteChange(String changeId);

}
