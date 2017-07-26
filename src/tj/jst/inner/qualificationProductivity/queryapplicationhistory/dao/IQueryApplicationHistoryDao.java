package com.tj.jst.inner.qualificationProductivity.queryapplicationhistory.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ������ʷ��¼��ѯ
 * @author DarkFlameMaster
 *
 */
public interface IQueryApplicationHistoryDao {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ��ת����ҳ���ѯ  
	 */
	public NewQualification queryapproval(String newQualId);
	
	//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	public List<DictionaryClass> queryCretLevels();
		
	//��������(�ֵ��TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums();
	
	//��תҳ���ж�
	public String queryUpdate(String newQualId);
	
	//��ѯԭ������Ϣ
	public NewQualification queryOldInfo(String corpId , int cretType , int cretLevel);
}
