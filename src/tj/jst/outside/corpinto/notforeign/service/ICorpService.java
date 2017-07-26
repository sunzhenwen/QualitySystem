package com.tj.jst.outside.corpinto.notforeign.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;


public interface ICorpService {
	
	//企业名称查询
	public Corp queryCorpName(String corpCode);
	
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
	
	//保存企业
	public String addCorp(Corp corp);
	
	//修改企业
	public String modifyCorp(Corp corp);

	public List<DictionaryClass> queryHLJCitys();
}
