package com.tj.jst.inner.qualificationProductivity.queryCorp.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * ��ѯ��ҵ���걨��������Ϣ ���ݿ�ӿ�
 * 
 * @author Administrator
 *
 */
public interface IQueryCorpApplyDao {

	/**
	 * ��ҳ����
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

}
