package com.tj.jst.inner.notforeigninfo.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;

public interface ICorpInfoDao {

	// 企业名称查询
	public String queryCorpName(CorpInfo corp);

	// 查询省
	public List<DictionaryClass> queryProvince();

	// 查询市
	public List<DictionaryClass> queryCity(String provinceId);

	// 通过corpId来查询企业信息
	public CorpInfo queryByCode(String corpCode);

	// 查询区
	public List<DictionaryClass> queryArea(String cityId);

	// 证件类型
	public List<DictionaryClass> queryIdCardType();

	// 企业登记注册类型
	public List<DictionaryClass> queryEconomicNum();

	// 注册资本币种
	public List<DictionaryClass> queryPrincipalUnit();

	// 保存企业
	public String addCorp(CorpInfo corp);

	// 分页查询
	public Page pagedQuery(Condition condition);

	// 通过corpId来查询企业信息
	public CorpInfo queryById(String corpId);

	// 修改企业信息
	public String modify(CorpInfo corp);

	// 通过corpId和corpName来判断修改的企业名称是否重复
	public String queryCorpInfoUsed(String corpId, String corpName);
}
