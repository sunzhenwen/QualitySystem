package com.tj.jst.outside.businessReport.corpchangearea.dao;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;

/**
 * ��ҵ�ύ�����ر��Dao�ӿ���
 * 
 * @author DarkFlameMaster
 *
 */
public interface ICorpChangeAreaDao {

	/**
	 * ��ѯ��ҵ��Ϣ
	 * 
	 * @param corpName
	 * @return
	 */
	public CertifiedCorp queryPage(String corpName);

	/**
	 * �ύ�����ر��������Ϣ
	 * 
	 * @param change
	 * @return
	 */
	public String approvalUpdate(ChangeArea change,int mark);

	/**
	 * ��ѯʡ
	 * 
	 * @return
	 */
	public List<DictionaryClass> queryProvince();

	/**
	 * ��ѯ��
	 * 
	 * @param provinceId
	 * @return
	 */
	public List<DictionaryClass> queryCity(String provinceId);

	/**
	 * ��ѯ�Ƿ���Ҫ��������
	 * 
	 * @param corpName
	 * @return
	 */
	public String queryMark(String corpName);
}
