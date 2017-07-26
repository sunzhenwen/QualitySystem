package com.tj.jst.inner.qualificationProductivity.queryCorp.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

public interface IQueryCorpDao {

	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * ��λ���ʷ��������ѯҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String[] certIds);

	/**
	 * ���ʷ��������ύ
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Corp> submitCertifiedService(List<CertifiedService> list);

	/**
	 * ��λ���ʷ��������ѯҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryAllCertifiedService();

	/**
	 * ���������ֵ�
	 * 
	 * @return
	 */
	public List<DictionaryClass> certName(String[] certIds);

	public List<DictionaryClass> queryCity(String provinceId);

	public List<DictionaryClass> queryProvince();

	public List<CertifiedService> queryGradeCertifiedService(String check);

}
