package com.tj.jst.inner.qualificationProductivity.queryCorp.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * ��ѯ��ҵ���걨��������Ϣ����ӿ�
 * 
 * @author Administrator
 *
 */
public interface IQueryCorpApplyService {

	/**
	 * ��ҳ����
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

}
