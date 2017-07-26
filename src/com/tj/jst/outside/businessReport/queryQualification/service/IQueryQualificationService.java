package com.tj.jst.outside.businessReport.queryQualification.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryQualification.model.Qualification;

/**
 * 查询企业资质信息
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryQualificationService {

	/**
	 * 查询资质
	 * 
	 * @param check
	 * @return
	 */
	public Page queryCertifiedService(Condition condition);

	/**
	 * 资质资格类型查询
	 * 
	 * @return
	 */
	public List<DictionaryClass> CertTypeNums();

	/**
	 * 资质资格等级查询
	 * 
	 * @return
	 */
	public List<DictionaryClass> TitleLevelNums();

	/**
	 * 资质资格获取方式查询
	 * 
	 * @return
	 */
	public List<DictionaryClass> AddTypeNums();

	/**
	 * 专业类别查询
	 * 
	 * @return
	 */
	public List<DictionaryClass> TradeBoundNums();

	/**
	 * 通过id来寻找企业资质详细信息
	 * 
	 * @param CertDetailId
	 * @return
	 */
	public Qualification queryById(String CertDetailId);

}
