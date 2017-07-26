package com.tj.jst.outside.businessReport.queryQualificationInfo.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryQualificationInfo.dao.IQueryQualificationInfoDao;
import com.tj.jst.outside.businessReport.queryQualificationInfo.dao.QueryQualificationInfoDaoImpl;
import com.tj.jst.outside.businessReport.queryQualificationInfo.model.QualificationInfo;

/**
 * 企业申请的资质信息状态查询
 * @author DarkFlameMaster
 *
 */
public class QueryQualificationInfoServiceImpl implements IQueryQualificationInfoService {

	/**
	 * 资质查询
	 */
	@Override
	public Page queryCertifiedService(Condition condition) {
		// TODO Auto-generated method stub
		IQueryQualificationInfoDao queryQualicationInfoDao = new QueryQualificationInfoDaoImpl();
		return queryQualicationInfoDao.queryCertifiedService(condition);
	}

	/**
	 * 资质资格类型查询
	 */
	@Override
	public List<DictionaryClass> CretLevelNums() {
		// TODO Auto-generated method stub
		IQueryQualificationInfoDao queryQualicationInfoDao = new QueryQualificationInfoDaoImpl();
		return queryQualicationInfoDao.CretLevelNums();
	}

	/**
	 * 通过ID来寻找企业资质详细信息
	 */
	@Override
	public QualificationInfo queryById(String NewQualId) {
		// TODO Auto-generated method stub
		IQueryQualificationInfoDao queryQualicationInfoDao = new QueryQualificationInfoDaoImpl();
		return queryQualicationInfoDao.queryById(NewQualId);
	}

	/**
	 * 通过Id来寻找删除的条目信息
	 */
	@Override
	public String deleteById(String NewQualId) {
		// TODO Auto-generated method stub
		IQueryQualificationInfoDao queryQualicationInfoDao = new QueryQualificationInfoDaoImpl();
		return queryQualicationInfoDao.deleteById(NewQualId);
	}
}
