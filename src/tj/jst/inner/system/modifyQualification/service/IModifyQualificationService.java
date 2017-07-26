package com.tj.jst.inner.system.modifyQualification.service;

import java.util.List;

import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.modifyQualification.condition.ModifyQualificationCondition;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;


public interface IModifyQualificationService {
	
	//查询省
	public List<DictionaryClass> queryProvince();
	
	//查询市
	public List<DictionaryClass> queryCity(String provinceId);
	
	//查询区
	public List<DictionaryClass> queryArea(String cityId);
	
	//证件类型
	public List<DictionaryClass> queryIdCardType();
	
	//企业登记注册类型
	public List<DictionaryClass> queryEconomicNum();
	
	//注册资本币种
	public List<DictionaryClass> queryPrincipalUnit();
	
	public List<DictionaryClass> queryHLJCitys();

	/**
	 * 企业申请信息列表
	 * @param condition
	 * @return
	 */
	public Page queryPage(ModifyQualificationCondition condition);

	/**
	 * 跳转修改页面
	 * @param newQualId
	 * @return
	 */
	public NewQualification modifyApplication(String newQualId);
	
	/**
	 * 企业资质申请信息修改操作
	 * @param newQualification
	 * @return
	 */
	public String modify(NewQualification newQualification);
}
