package com.tj.jst.outside.corpinto.foreign.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.foreign.model.ForeignCorp;

public interface IForeignCorpService {

	//企业名称查询企业
	public ForeignCorp queryCorpName(String corpCode);
	
	//查询所在国籍或地区
	public List<DictionaryClass> queryNation();
	
	//注册资本币种
	public List<DictionaryClass> queryPrincipalUnit();
	
	//保存外商企业
	public String addForeignCorp(ForeignCorp foreigncorp);
	
	//修改外商企业
	public String modifyForeignCorp(ForeignCorp foreigncorp);

	//查询投资人类型
	public List<DictionaryClass> queryIvestor();
}
