package com.tj.jst.inner.qualificationProductivity.twoQuery.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.twoQuery.dao.ITwoQueryDao;
import com.tj.jst.inner.qualificationProductivity.twoQuery.dao.TwoQueryDaoImpl;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 初审历史记录查询
 * @author DarkFlameMaster
 *
 */
public class TwoQueryServiceImpl implements ITwoQueryService{

	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		ITwoQueryDao twoQueryDao = new TwoQueryDaoImpl();
		return twoQueryDao.pagedQuery(condition);
	}

	@Override
	public NewQualification queryapproval(String newQualId) {
		// TODO Auto-generated method stub
		ITwoQueryDao twoQueryDao = new TwoQueryDaoImpl();
		return twoQueryDao.queryapproval(newQualId);
	}

	@Override
	public List<DictionaryClass> queryCretLevels() {
		// TODO Auto-generated method stub
		ITwoQueryDao twoQueryDao = new TwoQueryDaoImpl();
		return twoQueryDao.queryCretLevels();
	}

	@Override
	public List<DictionaryClass> queryAddTypeNums() {
		// TODO Auto-generated method stub
		ITwoQueryDao twoQueryDao = new TwoQueryDaoImpl();
		return twoQueryDao.queryAddTypeNums();
	}
	

}
