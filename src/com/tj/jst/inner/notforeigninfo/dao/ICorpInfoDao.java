package com.tj.jst.inner.notforeigninfo.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;

public interface ICorpInfoDao {

	// ��ҵ���Ʋ�ѯ
	public String queryCorpName(CorpInfo corp);

	// ��ѯʡ
	public List<DictionaryClass> queryProvince();

	// ��ѯ��
	public List<DictionaryClass> queryCity(String provinceId);

	// ͨ��corpId����ѯ��ҵ��Ϣ
	public CorpInfo queryByCode(String corpCode);

	// ��ѯ��
	public List<DictionaryClass> queryArea(String cityId);

	// ֤������
	public List<DictionaryClass> queryIdCardType();

	// ��ҵ�Ǽ�ע������
	public List<DictionaryClass> queryEconomicNum();

	// ע���ʱ�����
	public List<DictionaryClass> queryPrincipalUnit();

	// ������ҵ
	public String addCorp(CorpInfo corp);

	// ��ҳ��ѯ
	public Page pagedQuery(Condition condition);

	// ͨ��corpId����ѯ��ҵ��Ϣ
	public CorpInfo queryById(String corpId);

	// �޸���ҵ��Ϣ
	public String modify(CorpInfo corp);

	// ͨ��corpId��corpName���ж��޸ĵ���ҵ�����Ƿ��ظ�
	public String queryCorpInfoUsed(String corpId, String corpName);
}
