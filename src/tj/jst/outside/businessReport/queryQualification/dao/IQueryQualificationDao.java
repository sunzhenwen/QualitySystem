package com.tj.jst.outside.businessReport.queryQualification.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryQualification.model.Qualification;

/**
 * ��ҵ���ʲ�ѯ
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryQualificationDao {

	/**
	 * ��ѯ���Ҽ�������
	 * 
	 * @return
	 * @throws Exception
	 */
	public Page queryCertifiedService(Condition condition);

	/**
	 * �����ʸ����Ͳ�ѯ
	 * 
	 * @return
	 */
	public List<DictionaryClass> CertTypeNums();

	/**
	 * �����ʸ�ȼ���ѯ
	 * 
	 * @return
	 */
	public List<DictionaryClass> TitleLevelNums();

	/**
	 * �����ʸ��ȡ��ʽ��ѯ
	 * 
	 * @return
	 */
	public List<DictionaryClass> AddTypeNums();

	/**
	 * רҵ����ѯ
	 * 
	 * @return
	 */
	public List<DictionaryClass> TradeBoundNums();

	/**
	 * ͨ��id��Ѱ����ҵ������ϸ��Ϣ
	 * 
	 * @param CertDetailId
	 * @return
	 */
	public Qualification queryById(String CertDetailId);
}
