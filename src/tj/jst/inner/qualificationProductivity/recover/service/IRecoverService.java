package com.tj.jst.inner.qualificationProductivity.recover.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;

/**
 * ��ҵ���ʻָ�
 * @author Administrator
 *
 */
public interface IRecoverService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	
	/**
	 * ��������
	 * @return
	 */
	public void baseBatchRecover(String[] ids,String personalId,String personalName);
	public List<DictionaryClass> queryEconmicNums();
}
