package com.tj.jst.inner.system.servicecertdetailinfo.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.inner.system.servicecertdetailinfo.model.Department;

/**
 * 资质服务事项维护
 * @author Administrator
 *
 */
public interface ICertifiedServiceDao {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 添加
	 * @param certifiedService
	 */
	public void addCertifiedService(CertifiedService certifiedService);
	
	/**
	 * 查询单条
	 * @param certifiedService
	 */
	public CertifiedService queryById(String certId);
	
	/**
	 * 修改
	 * @param certifiedService
	 */
	public void modifyCertifiedService(CertifiedService certifiedService);
	
	/**
	 * 删除
	 */
	public void delectCertifiedService(String[] certIds);
	
	//资质类型(字典表：TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCretTypes();
	//资质等级(字典表：TBCERTTITLELEVELDIC)
	public List<DictionaryClass> queryCretLevels();
	//资质序列(字典表：TBTRADETYPEDIC)
	public List<DictionaryClass> queryCretSequences();
	//资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId);
	//资质级别(字典表：TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades();
	
	public List<Department> getDepartment();
}
