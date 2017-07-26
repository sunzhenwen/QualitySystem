package com.tj.jst.inner.system.qualificationRevocation.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.qualificationRevocation.condition.RevocationHistoryCondition;
import com.tj.jst.inner.system.qualificationRevocation.dao.IRevocationHistoryDao;
import com.tj.jst.inner.system.qualificationRevocation.dao.RevocationHistoryDaoImpl;
import com.tj.jst.inner.system.qualificationRevocation.model.QualificationRevocation;
import com.tj.jst.inner.system.servicecertdetailinfo.model.Department;

/**
 * 企业已获资质打回
 * @author Administrator
 *
 */
public class RevocationHistoryServiceImpl implements IRevocationHistoryService {

	
	/**
	 * 资质打回历史
	 */
	@Override
	public Page pagedQueryHistory(RevocationHistoryCondition historyCondition) {
		IRevocationHistoryDao dao = new RevocationHistoryDaoImpl();
		return dao.pagedQueryHistory(historyCondition);
	}

	//资质类型(字典表：TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		IRevocationHistoryDao certifiedServiceDao = new RevocationHistoryDaoImpl();
		return certifiedServiceDao.queryCretTypes();
	}

	//资质等级(字典表：TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		IRevocationHistoryDao certifiedServiceDao = new RevocationHistoryDaoImpl();
		return certifiedServiceDao.queryCretLevels();
	}

	//资质序列(字典表：TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		IRevocationHistoryDao certifiedServiceDao = new RevocationHistoryDaoImpl();
		return certifiedServiceDao.queryCretSequences();
	}

	//资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		IRevocationHistoryDao certifiedServiceDao = new RevocationHistoryDaoImpl();
		return certifiedServiceDao.querySpecialtyTypes(cretSequenceId);
	}
	//资质级别(字典表：TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades()
	{
		IRevocationHistoryDao certifiedServiceDao = new RevocationHistoryDaoImpl();
		return certifiedServiceDao.queryCretGrades();
	}
	public List<Department> getDepartment()
	{
		IRevocationHistoryDao certifiedServiceDao = new RevocationHistoryDaoImpl();
		return certifiedServiceDao.getDepartment();
	}

	/**
	 * 资质打回历史详细
	 */
	@Override
	public QualificationRevocation revocationHistoryPage(String revocationId) {
		// TODO Auto-generated method stub
		IRevocationHistoryDao dao = new RevocationHistoryDaoImpl();
		return dao.revocationHistoryPage(revocationId);
	}

	
	
}
