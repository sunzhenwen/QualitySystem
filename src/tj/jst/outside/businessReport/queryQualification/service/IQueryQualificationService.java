package com.tj.jst.outside.businessReport.queryQualification.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.queryQualification.model.Qualification;

/**
 * ��ѯ��ҵ������Ϣ
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryQualificationService {

	/**
	 * ��ѯ����
	 * 
	 * @param check
	 * @return
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
