package com.tj.jst.inner.qualificationProductivity.querySeparateQualification.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.queryAllApplication.dao.IQueryAllApplicationDao;
import com.tj.jst.inner.qualificationProductivity.queryAllApplication.dao.QueryAllApplicationDaoImpl;
import com.tj.jst.inner.qualificationProductivity.querySeparateQualification.dao.IQuerySeparateQualificationDao;
import com.tj.jst.inner.qualificationProductivity.querySeparateQualification.dao.QuerySeparateQualificationDaoImpl;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ȫ����Ϣ��ѯ
 * @author DarkFlameMaster
 *
 */
public class QuerySeparateQualificationServiceImpl implements IQuerySeparateQualificationService{

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IQuerySeparateQualificationDao queryDao = new QuerySeparateQualificationDaoImpl();
		return queryDao.pagedQuery(condition);
	}

	/**
	 * ��ѯ��ϸ��Ϣ
	 */
	@Override
	public NewQualification queryapproval(String newQualId) {
		// TODO Auto-generated method stub
		IQuerySeparateQualificationDao queryDao = new QuerySeparateQualificationDaoImpl();
		return queryDao.queryapproval(newQualId);
	}

	/**
	 * ���ʵȼ���ѯ
	 */
	@Override
	public List<DictionaryClass> queryCretLevels() {
		// TODO Auto-generated method stub
		IQuerySeparateQualificationDao queryDao = new QuerySeparateQualificationDaoImpl();
		return queryDao.queryCretLevels();
	}

	/**
	 * �������Ͳ�ѯ
	 */
	@Override
	public List<DictionaryClass> queryAddTypeNums() {
		// TODO Auto-generated method stub
		IQuerySeparateQualificationDao queryDao = new QuerySeparateQualificationDaoImpl();
		return queryDao.queryAddTypeNums();
	}

	@Override
	public NewQualification queryOldInfo(String corpId, int cretType,
			int cretLevel) {
		// TODO Auto-generated method stub
		IQuerySeparateQualificationDao queryDao = new QuerySeparateQualificationDaoImpl();
		return queryDao.queryOldInfo(corpId, cretType, cretLevel);
	}

	@Override
	public String queryUpdate(String newQualId) {
		// TODO Auto-generated method stub
		IQuerySeparateQualificationDao queryDao = new QuerySeparateQualificationDaoImpl();
		return queryDao.queryUpdate(newQualId);
	}

	
}
