package com.tj.jst.outside.businessReport.querycorpchangearea.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * ��ѯ�����ر������ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryCorpChangeAreaService {

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
