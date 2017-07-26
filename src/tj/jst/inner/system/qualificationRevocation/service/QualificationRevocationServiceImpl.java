package com.tj.jst.inner.system.qualificationRevocation.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.qualificationRevocation.condition.RevocationHistoryCondition;
import com.tj.jst.inner.system.qualificationRevocation.dao.IQualificationRevocationDao;
import com.tj.jst.inner.system.qualificationRevocation.dao.QualificationRevocationDaoImpl;
import com.tj.jst.inner.system.qualificationRevocation.model.QualificationRevocation;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.inner.system.servicecertdetailinfo.model.Department;

/**
 * 企业已获资质打回
 * @author Administrator
 *
 */
public class QualificationRevocationServiceImpl implements IQualificationRevocationService {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQualificationRevocationDao dao = new QualificationRevocationDaoImpl();
		return dao.pagedQuery(condition);
	}
	
	/**
	 * 跳转打回页面
	 */
	@Override
	public QualificationRevocation revocationPage(String relationId) {
		// TODO Auto-generated method stub
		IQualificationRevocationDao dao = new QualificationRevocationDaoImpl();
		return dao.revocationPage(relationId);
	}
	
	/**
	 * 资质打回操作
	 * @return
	 */
	@Override
	public String revocation(QualificationRevocation qualificationRevocation) {
		// TODO Auto-generated method stub
		IQualificationRevocationDao dao = new QualificationRevocationDaoImpl();
		return dao.revocation(qualificationRevocation);
	}
	
	//资质类型(字典表：TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		IQualificationRevocationDao certifiedServiceDao = new QualificationRevocationDaoImpl();
		return certifiedServiceDao.queryCretTypes();
	}

	//资质等级(字典表：TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		IQualificationRevocationDao certifiedServiceDao = new QualificationRevocationDaoImpl();
		return certifiedServiceDao.queryCretLevels();
	}

	//资质序列(字典表：TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		IQualificationRevocationDao certifiedServiceDao = new QualificationRevocationDaoImpl();
		return certifiedServiceDao.queryCretSequences();
	}

	//资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		IQualificationRevocationDao certifiedServiceDao = new QualificationRevocationDaoImpl();
		return certifiedServiceDao.querySpecialtyTypes(cretSequenceId);
	}
	//资质级别(字典表：TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades()
	{
		IQualificationRevocationDao certifiedServiceDao = new QualificationRevocationDaoImpl();
		return certifiedServiceDao.queryCretGrades();
	}
	public List<Department> getDepartment()
	{
		IQualificationRevocationDao certifiedServiceDao = new QualificationRevocationDaoImpl();
		return certifiedServiceDao.getDepartment();
	}

	
	
}
