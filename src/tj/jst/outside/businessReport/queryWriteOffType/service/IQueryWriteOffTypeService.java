package com.tj.jst.outside.businessReport.queryWriteOffType.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;

/**
 * ��ҵ����ע������״̬��ѯ
 * @author Administrator
 *
 */
public interface IQueryWriteOffTypeService {
	
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
	public void baseWriteOffApp(String[] ids);
	public List<DictionaryClass> queryEconmicNums();
}
