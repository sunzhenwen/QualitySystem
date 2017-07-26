package com.tj.jst.inner.system.modifyQualification.service;

import java.util.List;

import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.modifyQualification.condition.ModifyQualificationCondition;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;


public interface IModifyQualificationService {
	
	//��ѯʡ
	public List<DictionaryClass> queryProvince();
	
	//��ѯ��
	public List<DictionaryClass> queryCity(String provinceId);
	
	//��ѯ��
	public List<DictionaryClass> queryArea(String cityId);
	
	//֤������
	public List<DictionaryClass> queryIdCardType();
	
	//��ҵ�Ǽ�ע������
	public List<DictionaryClass> queryEconomicNum();
	
	//ע���ʱ�����
	public List<DictionaryClass> queryPrincipalUnit();
	
	public List<DictionaryClass> queryHLJCitys();

	/**
	 * ��ҵ������Ϣ�б�
	 * @param condition
	 * @return
	 */
	public Page queryPage(ModifyQualificationCondition condition);

	/**
	 * ��ת�޸�ҳ��
	 * @param newQualId
	 * @return
	 */
	public NewQualification modifyApplication(String newQualId);
	
	/**
	 * ��ҵ����������Ϣ�޸Ĳ���
	 * @param newQualification
	 * @return
	 */
	public String modify(NewQualification newQualification);
}
