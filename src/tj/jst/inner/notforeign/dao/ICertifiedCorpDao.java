package com.tj.jst.inner.notforeign.dao;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;


public interface ICertifiedCorpDao {
	
	
	//֤������
	public List<DictionaryClass> queryIdCardType();
	
	//�޸���ҵ
	public String modifyCorp(CertifiedCorp corp);
	
	//��ҵ��ѯ
	public CertifiedCorp queryCorp(String corpId);
	
	//�ж���ҵ�Ƿ��λ
	public String perchCheck(String corpName);
	
	//�޸�δ��λ��ҵ
	public String modifyCorpTwo(CertifiedCorp corp);
	
	//��֯��������֤��ѯ
	public String queryCorpCode(CertifiedCorp corp);
	
			//��ѯʡ
			public List<DictionaryClass> queryProvince();
			
			//��ѯ��
			public List<DictionaryClass> queryCity(String provinceId);
			
			//��ѯ��
			public List<DictionaryClass> queryArea(String cityId);
			
			//��ҵ�Ǽ�ע������
			public List<DictionaryClass> queryEconomicNum();
			
			//ע���ʱ�����
			public List<DictionaryClass> queryPrincipalUnit();
}
