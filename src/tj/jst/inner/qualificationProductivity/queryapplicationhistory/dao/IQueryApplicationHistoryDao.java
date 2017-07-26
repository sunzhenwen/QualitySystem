package com.tj.jst.inner.qualificationProductivity.queryapplicationhistory.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 审批历史记录查询
 * @author DarkFlameMaster
 *
 */
public interface IQueryApplicationHistoryDao {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 跳转审批页面查询  
	 */
	public NewQualification queryapproval(String newQualId);
	
	//资质等级(字典表：TBCERTTITLELEVELDIC)
	public List<DictionaryClass> queryCretLevels();
		
	//申请类型(字典表：TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums();
	
	//跳转页面判断
	public String queryUpdate(String newQualId);
	
	//查询原资质信息
	public NewQualification queryOldInfo(String corpId , int cretType , int cretLevel);
}
