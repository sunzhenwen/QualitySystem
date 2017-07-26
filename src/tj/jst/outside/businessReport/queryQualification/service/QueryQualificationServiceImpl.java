package com.tj.jst.outside.businessReport.queryQualification.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryQualification.dao.IQueryQualificationDao;
import com.tj.jst.outside.businessReport.queryQualification.dao.QueryQualificationDaoImpl;
import com.tj.jst.outside.businessReport.queryQualification.model.Qualification;

/**
 * 查询资质
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryQualificationServiceImpl implements
		IQueryQualificationService {

	/**
	 * 资质查询
	 */
	@Override
	public Page queryCertifiedService(Condition condition) {
		// TODO Auto-generated method stub
		IQueryQualificationDao queryQualificationDao = new QueryQualificationDaoImpl();
		return queryQualificationDao.queryCertifiedService(condition);
	}

	/**
	 * 资质资格类型查询
	 */
	@Override
	public List<DictionaryClass> CertTypeNums() {
		// TODO Auto-generated method stub
		IQueryQualificationDao queryQualificationDao = new QueryQualificationDaoImpl();
		return queryQualificationDao.CertTypeNums();
	}

	/**
	 * 资质资格等级查询
	 */
	@Override
	public List<DictionaryClass> TitleLevelNums() {
		// TODO Auto-generated method stub
		IQueryQualificationDao queryQualificationDao = new QueryQualificationDaoImpl();
		return queryQualificationDao.TitleLevelNums();
	}

	/**
	 * 资质资格获取方式查询
	 */
	@Override
	public List<DictionaryClass> AddTypeNums() {
		// TODO Auto-generated method stub
		IQueryQualificationDao queryQualificationDao = new QueryQualificationDaoImpl();
		return queryQualificationDao.AddTypeNums();
	}

	/**
	 * 专业类别查询
	 */
	@Override
	public List<DictionaryClass> TradeBoundNums() {
		// TODO Auto-generated method stub
		IQueryQualificationDao queryQualificationDao = new QueryQualificationDaoImpl();
		return queryQualificationDao.TradeBoundNums();
	}

	/**
	 * 通过ID来寻找企业资质详细信息
	 */
	@Override
	public Qualification queryById(String CertDetailId) {
		// TODO Auto-generated method stub
		IQueryQualificationDao queryQualificationDao = new QueryQualificationDaoImpl();
		return queryQualificationDao.queryById(CertDetailId);
	}

}
