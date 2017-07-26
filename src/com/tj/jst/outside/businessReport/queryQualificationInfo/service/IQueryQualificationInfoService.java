package com.tj.jst.outside.businessReport.queryQualificationInfo.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryQualificationInfo.model.QualificationInfo;

/**
 * 企业申请资质状态查询
 * @author DarkFlameMaster
 *
 */
public interface IQueryQualificationInfoService {

	/**
	 * 查询资质
	 * @param condition
	 * @return
	 */
	public Page queryCertifiedService(Condition condition);
	
	/**
	 * 资质资格类型查询
	 * @return
	 */
	public List<DictionaryClass> CretLevelNums();
	
	/**
	 * 通过Id来查询公司基础信息
	 * @param CertDetailId
	 * @return
	 */
	public QualificationInfo queryById(String CertDetailId);
	
	/**
	 * 通过Id 来删除企业申请的资质上报条目
	 * 
	 * @param CertDetailId
	 * @return
	 */
	public String deleteById(String NewQualId);
	
}
