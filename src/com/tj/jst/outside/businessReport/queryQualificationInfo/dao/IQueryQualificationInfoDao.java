package com.tj.jst.outside.businessReport.queryQualificationInfo.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryQualificationInfo.model.QualificationInfo;

/**
 * 企业所申请的资质信息状态查询
 * @author DarkFlameMaster
 *
 */
public interface IQueryQualificationInfoDao {

	/**
	 * 查询国家级别资质
	 * 
	 * @return
	 * @throws Exception
	 */
	public Page queryCertifiedService(Condition condition);
	
	/**
	 * 资质资格类型查询
	 * 
	 * @return
	 */
	public List<DictionaryClass> CretLevelNums();
	
	/**
	 * 通过id来寻找企业资质详细信息
	 * 
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
	public String deleteById(String CertDetailId);
}
