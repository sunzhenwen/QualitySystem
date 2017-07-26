package com.tj.jst.outside.businessReport.queryQualificationInfo.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryQualificationInfo.dao.IQueryQualificationInfoDao;
import com.tj.jst.outside.businessReport.queryQualificationInfo.dao.QueryQualificationInfoDaoImpl;
import com.tj.jst.outside.businessReport.queryQualificationInfo.model.QualificationInfo;

/**
 * ��ҵ�����������Ϣ״̬��ѯ
 * @author DarkFlameMaster
 *
 */
public class QueryQualificationInfoServiceImpl implements IQueryQualificationInfoService {

	/**
	 * ���ʲ�ѯ
	 */
	@Override
	public Page queryCertifiedService(Condition condition) {
		// TODO Auto-generated method stub
		IQueryQualificationInfoDao queryQualicationInfoDao = new QueryQualificationInfoDaoImpl();
		return queryQualicationInfoDao.queryCertifiedService(condition);
	}

	/**
	 * �����ʸ����Ͳ�ѯ
	 */
	@Override
	public List<DictionaryClass> CretLevelNums() {
		// TODO Auto-generated method stub
		IQueryQualificationInfoDao queryQualicationInfoDao = new QueryQualificationInfoDaoImpl();
		return queryQualicationInfoDao.CretLevelNums();
	}

	/**
	 * ͨ��ID��Ѱ����ҵ������ϸ��Ϣ
	 */
	@Override
	public QualificationInfo queryById(String NewQualId) {
		// TODO Auto-generated method stub
		IQueryQualificationInfoDao queryQualicationInfoDao = new QueryQualificationInfoDaoImpl();
		return queryQualicationInfoDao.queryById(NewQualId);
	}

	/**
	 * ͨ��Id��Ѱ��ɾ������Ŀ��Ϣ
	 */
	@Override
	public String deleteById(String NewQualId) {
		// TODO Auto-generated method stub
		IQueryQualificationInfoDao queryQualicationInfoDao = new QueryQualificationInfoDaoImpl();
		return queryQualicationInfoDao.deleteById(NewQualId);
	}
}
