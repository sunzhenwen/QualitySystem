package com.tj.jst.outside.corpinto.foreign.dao;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.foreign.model.ForeignCorp;

public interface IForeignCorpDao {

	//组织机构代码证查询企业
	public ForeignCorp queryCorpName(String corpCode);
	
	//查询国籍或地区
	public List<DictionaryClass> queryNation();
	
	//保存企业
	public String addForeignCorp(ForeignCorp foreignCorp);
		
	//修改企业
	public String modifyForeignCorp(ForeignCorp foreignCorp);
	
	//注册资本币种
	public List<DictionaryClass> queryPrincipalUnit();

	//投资人类型
	public List<DictionaryClass> queryIvestor();
	
}
