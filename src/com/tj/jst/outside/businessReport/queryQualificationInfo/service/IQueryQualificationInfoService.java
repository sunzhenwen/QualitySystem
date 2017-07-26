package com.tj.jst.outside.businessReport.queryQualificationInfo.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryQualificationInfo.model.QualificationInfo;

/**
 * ��ҵ��������״̬��ѯ
 * @author DarkFlameMaster
 *
 */
public interface IQueryQualificationInfoService {

	/**
	 * ��ѯ����
	 * @param condition
	 * @return
	 */
	public Page queryCertifiedService(Condition condition);
	
	/**
	 * �����ʸ����Ͳ�ѯ
	 * @return
	 */
	public List<DictionaryClass> CretLevelNums();
	
	/**
	 * ͨ��Id����ѯ��˾������Ϣ
	 * @param CertDetailId
	 * @return
	 */
	public QualificationInfo queryById(String CertDetailId);
	
	/**
	 * ͨ��Id ��ɾ����ҵ����������ϱ���Ŀ
	 * 
	 * @param CertDetailId
	 * @return
	 */
	public String deleteById(String NewQualId);
	
}
