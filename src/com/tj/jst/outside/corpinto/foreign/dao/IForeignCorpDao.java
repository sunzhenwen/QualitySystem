package com.tj.jst.outside.corpinto.foreign.dao;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.foreign.model.ForeignCorp;

public interface IForeignCorpDao {

	//��֯��������֤��ѯ��ҵ
	public ForeignCorp queryCorpName(String corpCode);
	
	//��ѯ���������
	public List<DictionaryClass> queryNation();
	
	//������ҵ
	public String addForeignCorp(ForeignCorp foreignCorp);
		
	//�޸���ҵ
	public String modifyForeignCorp(ForeignCorp foreignCorp);
	
	//ע���ʱ�����
	public List<DictionaryClass> queryPrincipalUnit();

	//Ͷ��������
	public List<DictionaryClass> queryIvestor();
	
}
