package com.tj.jst.inner.system.servicecertdetailinfo.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.servicecertdetailinfo.dao.CertifiedServiceDaoImpl;
import com.tj.jst.inner.system.servicecertdetailinfo.dao.ICertifiedServiceDao;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.inner.system.servicecertdetailinfo.model.Department;

/**
 * 资质服务事项维护
 * @author Administrator
 *
 */
public class CertifiedServiceImpl implements ICertifiedService {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.pagedQuery(condition);
	}

	/**
	 * 添加
	 * @param certifiedService
	 */
	public void addCertifiedService(CertifiedService certifiedService)
	{
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		certifiedServiceDao.addCertifiedService(certifiedService);
	}
	
	/**
	 * 查询单条
	 * @param certifiedService
	 */
	public CertifiedService queryById(String certId)
	{
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.queryById(certId);
	}
	
	/**
	 * 修改
	 * @param certifiedService
	 */
	public void modifyCertifiedService(CertifiedService certifiedService)
	{
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		certifiedServiceDao.modifyCertifiedService(certifiedService);
	}
	
	/**
	 * 删除
	 */
	public void delectCertifiedService(String[] certIds)
	{
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		certifiedServiceDao.delectCertifiedService(certIds);
	}
	
	//资质类型(字典表：TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.queryCretTypes();
	}

	//资质等级(字典表：TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.queryCretLevels();
	}

	//资质序列(字典表：TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.queryCretSequences();
	}

	//资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.querySpecialtyTypes(cretSequenceId);
	}
	//资质级别(字典表：TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades()
	{
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.queryCretGrades();
	}
	public List<Department> getDepartment()
	{
		ICertifiedServiceDao certifiedServiceDao = new CertifiedServiceDaoImpl();
		return certifiedServiceDao.getDepartment();
	}
}
