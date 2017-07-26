package com.tj.jst.inner.notforeign.dao;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;


public interface ICertifiedCorpDao {
	
	
	//证件类型
	public List<DictionaryClass> queryIdCardType();
	
	//修改企业
	public String modifyCorp(CertifiedCorp corp);
	
	//企业查询
	public CertifiedCorp queryCorp(String corpId);
	
	//判断企业是否就位
	public String perchCheck(String corpName);
	
	//修改未就位企业
	public String modifyCorpTwo(CertifiedCorp corp);
	
	//组织机构代码证查询
	public String queryCorpCode(CertifiedCorp corp);
	
			//查询省
			public List<DictionaryClass> queryProvince();
			
			//查询市
			public List<DictionaryClass> queryCity(String provinceId);
			
			//查询区
			public List<DictionaryClass> queryArea(String cityId);
			
			//企业登记注册类型
			public List<DictionaryClass> queryEconomicNum();
			
			//注册资本币种
			public List<DictionaryClass> queryPrincipalUnit();
}
