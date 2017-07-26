package com.tj.jst.inner.qualificationProductivity.queryCorp.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

public interface IQueryCorpService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	
	/**
	 * 就位资质服务事项查询页面
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String[] certIds);
	
	
	/**
	 * 就位资质服务事项查询页面
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryAllCertifiedService();
	

	
	/**
	 * 资质服务事项提交
	 * @param string2 
	 * @param string 
	 * @return
	 * @throws Exception
	 */
	public List<Corp> submitCertifiedService(String[] certIds);
	
	
	/**
	 * 资质名称字典
	 * @return
	 */
	public List<DictionaryClass> certName(String[] certIds);


	public List<DictionaryClass> queryCity(String provinceId);


	public List<DictionaryClass> queryProvince();


	//按照国家、省、市资质查询
	public List<CertifiedService> queryGradeCertifiedService(String check);
	
}