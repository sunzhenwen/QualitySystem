package com.tj.jst.outside.corpinto.foreign.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.foreign.model.ForeignCorp;

public interface IForeignCorpService {

	//��ҵ���Ʋ�ѯ��ҵ
	public ForeignCorp queryCorpName(String corpCode);
	
	//��ѯ���ڹ��������
	public List<DictionaryClass> queryNation();
	
	//ע���ʱ�����
	public List<DictionaryClass> queryPrincipalUnit();
	
	//����������ҵ
	public String addForeignCorp(ForeignCorp foreigncorp);
	
	//�޸�������ҵ
	public String modifyForeignCorp(ForeignCorp foreigncorp);

	//��ѯͶ��������
	public List<DictionaryClass> queryIvestor();
}
