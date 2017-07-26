package com.tj.jst.inner.qualificationProductivity.twoQuery.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 初审审批历史记录查询
 * @author DarkFlameMaster
 *
 */
public interface ITwoQueryService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 跳转审批页面
	 * @return
	 */
	public NewQualification queryapproval(String newQualId);
	
	/**
	 * 资质等级(字典表：TBCERTTITLELEVELDIC)
	 */
	public List<DictionaryClass> queryCretLevels();
	
	/**
	 * 申请类型(字典表：TBADDTYPEDIC)
	 */
	public List<DictionaryClass> queryAddTypeNums();

}
