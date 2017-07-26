package com.tj.jst.inner.qualificationProductivity.queryapplicationhistory.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.queryapplicationhistory.dao.IQueryApplicationHistoryDao;
import com.tj.jst.inner.qualificationProductivity.queryapplicationhistory.dao.QueryApplicationHistoryDaoImpl;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 审批历史记录
 * @author DarkFlameMaster
 *
 */
public class QueryApplicationHistoryServiceImpl implements IQueryApplicationHistroyService {

	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IQueryApplicationHistoryDao queryApplication = new QueryApplicationHistoryDaoImpl();
		return queryApplication.pagedQuery(condition);
	}

	@Override
	public NewQualification queryapproval(String newQualId) {
		// TODO Auto-generated method stub
		IQueryApplicationHistoryDao queryApplication = new QueryApplicationHistoryDaoImpl();
		return queryApplication.queryapproval(newQualId);
	}


	@Override
	public List<DictionaryClass> queryCretLevels() {
		// TODO Auto-generated method stub
		IQueryApplicationHistoryDao queryApplication = new QueryApplicationHistoryDaoImpl();
		return queryApplication.queryCretLevels();
	}

	
	@Override
	public List<DictionaryClass> queryAddTypeNums() {
		// TODO Auto-generated method stub
		IQueryApplicationHistoryDao queryApplication = new QueryApplicationHistoryDaoImpl();
		return queryApplication.queryAddTypeNums();
	}

	@Override
	public String queryUpdate(String newQualId) {
		// TODO Auto-generated method stub
		IQueryApplicationHistoryDao queryApplication = new QueryApplicationHistoryDaoImpl();
		return queryApplication.queryUpdate(newQualId);
	}

	@Override
	public NewQualification queryOldInfo(String corpId, int cretType,
			int cretLevel) {
		// TODO Auto-generated method stub
		IQueryApplicationHistoryDao queryApplication = new QueryApplicationHistoryDaoImpl();
		return queryApplication.queryOldInfo(corpId, cretType, cretLevel);
	}

}
