package com.tj.jst.outside.corpinto.notforeign.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;


public interface ICorpService {
	
	//��ҵ���Ʋ�ѯ
	public Corp queryCorpName(String corpCode);
	
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
	
	//������ҵ
	public String addCorp(Corp corp);
	
	//�޸���ҵ
	public String modifyCorp(Corp corp);

	public List<DictionaryClass> queryHLJCitys();
}
