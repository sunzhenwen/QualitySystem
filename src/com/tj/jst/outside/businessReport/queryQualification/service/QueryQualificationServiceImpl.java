package com.tj.jst.outside.businessReport.queryQualification.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryQualification.dao.IQueryQualificationDao;
import com.tj.jst.outside.businessReport.queryQualification.dao.QueryQualificationDaoImpl;
import com.tj.jst.outside.businessReport.queryQualification.model.Qualification;

/**
 * ��ѯ����
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryQualificationServiceImpl implements
		IQueryQualificationService {

	/**
	 * ���ʲ�ѯ
	 */
	@Override
	public Page queryCertifiedService(Condition condition) {
		// TODO Auto-generated method stub
		IQueryQualificationDao queryQualificationDao = new QueryQualificationDaoImpl();
		return queryQualificationDao.queryCertifiedService(condition);
	}

	/**
	 * �����ʸ����Ͳ�ѯ
	 */
	@Override
	public List<DictionaryClass> CertTypeNums() {
		// TODO Auto-generated method stub
		IQueryQualificationDao queryQualificationDao = new QueryQualificationDaoImpl();
		return queryQualificationDao.CertTypeNums();
	}

	/**
	 * �����ʸ�ȼ���ѯ
	 */
	@Override
	public List<DictionaryClass> TitleLevelNums() {
		// TODO Auto-generated method stub
		IQueryQualificationDao queryQualificationDao = new QueryQualificationDaoImpl();
		return queryQualificationDao.TitleLevelNums();
	}

	/**
	 * �����ʸ��ȡ��ʽ��ѯ
	 */
	@Override
	public List<DictionaryClass> AddTypeNums() {
		// TODO Auto-generated method stub
		IQueryQualificationDao queryQualificationDao = new QueryQualificationDaoImpl();
		return queryQualificationDao.AddTypeNums();
	}

	/**
	 * רҵ����ѯ
	 */
	@Override
	public List<DictionaryClass> TradeBoundNums() {
		// TODO Auto-generated method stub
		IQueryQualificationDao queryQualificationDao = new QueryQualificationDaoImpl();
		return queryQualificationDao.TradeBoundNums();
	}

	/**
	 * ͨ��ID��Ѱ����ҵ������ϸ��Ϣ
	 */
	@Override
	public Qualification queryById(String CertDetailId) {
		// TODO Auto-generated method stub
		IQueryQualificationDao queryQualificationDao = new QueryQualificationDaoImpl();
		return queryQualificationDao.queryById(CertDetailId);
	}

}
