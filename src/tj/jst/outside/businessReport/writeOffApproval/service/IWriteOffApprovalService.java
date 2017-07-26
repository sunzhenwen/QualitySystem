package com.tj.jst.outside.businessReport.writeOffApproval.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;

/**
 * 企业资质注销申请
 * @author Administrator
 *
 */
public interface IWriteOffApprovalService {
	
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
	public void baseWriteOffApp(String[] ids);
	public List<DictionaryClass> queryEconmicNums();
}
