package com.tj.jst.inner.qualificationProductivity.recover.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;

/**
 * 企业资质恢复
 * @author Administrator
 *
 */
public interface IRecoverService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	
	/**
	 * 批量审批
	 * @return
	 */
	public void baseBatchRecover(String[] ids,String personalId,String personalName);
	public List<DictionaryClass> queryEconmicNums();
}
